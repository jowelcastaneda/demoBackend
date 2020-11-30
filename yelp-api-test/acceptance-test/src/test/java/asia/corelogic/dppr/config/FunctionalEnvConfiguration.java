package asia.corelogic.dppr.config;

import asia.corelogic.dppr.credentials.Credentials;
import asia.corelogic.dppr.credentials.TokenCache;
import asia.corelogic.dppr.credentials.UserCredentials;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.text.SimpleDateFormat;
import java.time.Duration;

@Configuration
@PropertySource("classpath:/dppr-api-${test-env:dev-local}.properties")
public class FunctionalEnvConfiguration {
    private static final String DATE_FORMAT = "yyyy-MM-dd";

    @Value("${test.application.base.uri}")
    private String applicationBaseUri;

    @Value("${test.access-uri}")
    private String accessBaseUri;

    @Value("${test.client.id}")
    private String clientId;

    @Value("${test.client.secret}")
    private String clientSecret;

    @Value("${test.user.name}")
    private String userName;

    @Value("${test.app.acct.usr.guid}")
    private String clAppAcctUsrGuid;

    @Value("${test.application.key}")
    private String clApplicationKey;

    @Value("${test.api.key}")
    private String apiKey;

    @Value("${test.api.secret}")
    private String secret;

    @Value("${test.redirect.uri}")
    private String redirectUri;

    @Value("${test.environment}")
    private String environment;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public WebTestClient webTestClient() {
        return WebTestClient.bindToServer()
            .baseUrl(applicationBaseUri)
            .responseTimeout(Duration.ofSeconds(20))
            .filter(new LoggingRequestFilterFunction())
            .defaultHeader("Authorization", getCredentials().getAuthHeader())
            .build();
    }

    @Bean
    public ObjectMapper objectMapperBuilder() {
        return new Jackson2ObjectMapperBuilder()
            .failOnUnknownProperties(false)
            .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .featuresToEnable(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY)
            .serializationInclusion(JsonInclude.Include.NON_EMPTY)
            .dateFormat(new SimpleDateFormat(DATE_FORMAT))
            .build();
    }

    @Bean
    public TokenCache getTokenCache() {
        return new TokenCache(accessBaseUri);
    }


    @Bean
    public Credentials getCredentials() {
        return new Credentials(getTokenCache(), new UserCredentials(clientId, clientSecret, userName, clAppAcctUsrGuid, clApplicationKey, apiKey, secret, redirectUri));
    }

}

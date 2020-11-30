package asia.corelogic.dppr;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@SuppressWarnings("checkstyle:hideutilityclassconstructor")
public class DpprApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(DpprApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }
}

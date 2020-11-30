package asia.corelogic.dppr;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DpprApplicationIntegrationTest {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    @DisplayName("Status service is active")
    void statusServiceExists() {
        webTestClient.get().uri("/private/status").
            exchange().expectStatus()
            .isOk()
            .expectBody()
            .jsonPath("$.status.applicationStatus.name").isEqualTo("dppr")
            .jsonPath("$.status.applicationStatus.status").isEqualTo("GREEN")
            .jsonPath("$.status.applicationStatus.statusDetails").isEqualTo("Ok");
    }
}
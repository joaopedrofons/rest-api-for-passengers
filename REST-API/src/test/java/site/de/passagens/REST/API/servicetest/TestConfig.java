package site.de.passagens.rest.api.servicetest;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import site.de.passagens.restapi.service.AirlineService;

@Configuration
public class TestConfig {

    @Bean
    public AirlineService airlineService() {
        // Retorne um mock de AirlineService para uso em testes
        return Mockito.mock(AirlineService.class);
    }
}

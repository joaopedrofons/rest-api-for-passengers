package site.de.passagens.rest.api.controllertest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import site.de.passagens.restapi.controller.AirlineController;
import site.de.passagens.restapi.entity.Airline;
import site.de.passagens.restapi.service.AirlineService;

@ExtendWith(MockitoExtension.class)
public class AirlineControllerTest {

    @Mock
    private AirlineService airlineService;

    @InjectMocks
    private AirlineController airlineController;

    @Test
    public void testCreateAirline() {
        String nomeDaCompanhiaAerea = "Test Airline";
        Airline companhiaAereaEsperada = new Airline(nomeDaCompanhiaAerea);
        when(airlineService.createAirLine(nomeDaCompanhiaAerea)).thenReturn(Optional.of(companhiaAereaEsperada));

        ResponseEntity<Airline> response = airlineController.createAirLine(companhiaAereaEsperada);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(nomeDaCompanhiaAerea, response.getBody().getName());
    }

    // Adicione mais testes conforme necessário
}

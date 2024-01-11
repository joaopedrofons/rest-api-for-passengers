package site.de.passagens.rest.api.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import site.de.passagens.restapi.entity.Airline;
import site.de.passagens.restapi.repository.AirlineRepository;
import site.de.passagens.restapi.service.AirlineService;

@ExtendWith(MockitoExtension.class)
public class AirlineServiceTest {

    @Mock
    private AirlineRepository airlineRepository;

    @InjectMocks
    private AirlineService airlineService;

    @Test
    public void testCreateAirline() {
        String nomeDaCompanhiaAerea = "Test Airline";
        Airline companhiaAereaEsperada = new Airline(nomeDaCompanhiaAerea);
        when(airlineRepository.save(any(Airline.class))).thenReturn(companhiaAereaEsperada);

        Optional<Airline> companhiaAereaCriada = airlineService.createAirLine(nomeDaCompanhiaAerea);

        assertTrue(companhiaAereaCriada.isPresent());
        assertEquals(nomeDaCompanhiaAerea, companhiaAereaCriada.get().getName());
    }

    // Adicione mais testes conforme necessário
}

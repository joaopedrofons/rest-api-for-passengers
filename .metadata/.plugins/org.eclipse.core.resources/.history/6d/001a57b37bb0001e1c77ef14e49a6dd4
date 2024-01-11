package site.de.passagens.rest.api.controllertest;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import site.de.passagens.restapi.controller.AirlineController;
import site.de.passagens.restapi.entity.Airline;
import site.de.passagens.restapi.service.AirlineService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {MockitoTestExecutionListener.class})
public class AirlineControllerTest {

    @InjectMocks
    AirlineController airlineController;

    @Mock
    AirlineService airlineService;

    @Test
    public void testCreateAirLine() {
        String airlineName = "Test Airline";

        Airline expectedAirline = createAirline(airlineName);

        when(airlineService.createAirLine(airlineName)).thenReturn(expectedAirline);

        Airline requestAirline = createAirline(airlineName);

        Airline actualAirline = airlineController.createAirLine(requestAirline);

        assertNotNull(actualAirline, "The airline is null.");
        assertEquals(expectedAirline.getName(), actualAirline.getName());
    }

    private Airline createAirline(String airlineName) {
        Airline airline = new Airline();
        airline.setName(airlineName);
        return airline;
    }
}

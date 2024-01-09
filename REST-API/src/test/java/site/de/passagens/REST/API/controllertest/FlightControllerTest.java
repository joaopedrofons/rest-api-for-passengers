package site.de.passagens.REST.API.controllertest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import site.de.passagens.REST.API.RestApiApplication;
import site.de.passagens.REST.API.controller.FlightController;
import site.de.passagens.REST.API.entity.Airline;
import site.de.passagens.REST.API.entity.Flight;
import site.de.passagens.REST.API.service.AirlineService;
import site.de.passagens.REST.API.service.FlightService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = RestApiApplication.class)
public class FlightControllerTest {

    @InjectMocks
    FlightController flightController;

    @Mock
    FlightService flightService;

    @Mock
    AirlineService airlineService;

    private static final String AIRLINE_NAME = "Airline Test";
    private static final String MODEL_NAME = "Model Test";
    private static final int MAX_CAPACITY = 200;

    private Flight flight;
    private Airline airline;

    @BeforeEach
    public void setup() {
        flight = new Flight();
        flight.setModel(MODEL_NAME);
        flight.setMaxCapacity(MAX_CAPACITY);

        airline = new Airline();
        airline.setName(AIRLINE_NAME);

        flight.setAirline(airline);
    }

    @Test
    public void testCreateFlight() {
        when(airlineService.findByName(airline.getName())).thenReturn(Optional.of(airline));
        when(flightService.createFlight(flight)).thenReturn(flight);

        Flight result = flightController.createFlight(flight);

        assertEquals(flight.getModel(), result.getModel());
        assertEquals(flight.getMaxCapacity(), result.getMaxCapacity());
        assertEquals(airline.getName(), result.getAirline().getName());
    }
}

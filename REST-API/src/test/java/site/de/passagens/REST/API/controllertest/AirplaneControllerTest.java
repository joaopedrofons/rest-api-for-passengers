package site.de.passagens.REST.API.controllertest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import site.de.passagens.REST.API.RestApiApplication;
import site.de.passagens.REST.API.controller.AirplaneController;
import site.de.passagens.REST.API.entity.Airline;
import site.de.passagens.REST.API.entity.Airplane;
import site.de.passagens.REST.API.service.AirlineService;
import site.de.passagens.REST.API.service.AirplaneService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = RestApiApplication.class)
public class AirplaneControllerTest {

    @InjectMocks
    AirplaneController airplaneController;

    @Mock
    AirplaneService airplaneService;

    @Mock
    AirlineService airlineService;

    private static final String AIRLINE_NAME = "Airline Test";
    private static final String MODEL_NAME = "Model Test";
    private static final int MAX_CAPACITY = 200;
    private static final int TOTAL_CAPACITY = 1000;

    private Airplane airplane;
    private Airline airline;

    @BeforeEach
    public void setup() {
        airplane = new Airplane();
        airplane.setModel(MODEL_NAME);
        airplane.setMaxCapacity(MAX_CAPACITY);

        airline = new Airline();
        airline.setName(AIRLINE_NAME);

        airplane.setAirline(airline);
    }

    @Test
    public void testCreateAirplane() {
        when(airlineService.findByName(airplane.getAirline().getName())).thenReturn(Optional.of(airline));
        when(airplaneService.createAirplane(airplane.getModel(), airplane.getMaxCapacity(), airline)).thenReturn(airplane);

        Airplane result = airplaneController.createAirplane(airplane);

        assertEquals(airplane.getModel(), result.getModel());
        assertEquals(airplane.getMaxCapacity(), result.getMaxCapacity());
        assertEquals(airline.getName(), result.getAirline().getName());
    }

    @Test
    public void testGetTotalCapacity() {
        when(airlineService.findByName(AIRLINE_NAME)).thenReturn(Optional.of(airline));
        when(airplaneService.getTotalCapacity(airline)).thenReturn(TOTAL_CAPACITY);

        int result = airplaneController.getTotalCapacity(AIRLINE_NAME);

        assertEquals(TOTAL_CAPACITY, result);
    }
}

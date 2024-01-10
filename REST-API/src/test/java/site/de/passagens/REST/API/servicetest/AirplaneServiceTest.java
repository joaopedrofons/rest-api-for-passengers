package site.de.passagens.rest.api.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import site.de.passagens.restapi.entity.Airline;
import site.de.passagens.restapi.entity.Airplane;
import site.de.passagens.restapi.repository.AirplaneRepository;
import site.de.passagens.restapi.service.AirplaneService;

@ExtendWith(MockitoExtension.class)
public class AirplaneServiceTest {

    private static final String TEST_MODEL = "Test Model";
    private static final int MAX_CAPACITY = 100;
    private static final String TEST_AIRLINE = "Test Airline";

    @Mock
    private AirplaneRepository airplaneRepository;

    @InjectMocks
    private AirplaneService airplaneService;

    private Airline airline;
    private Airplane airplane;

    @BeforeEach
    public void setUp() {
        airline = new Airline(TEST_AIRLINE);
        airplane = new Airplane(TEST_MODEL, MAX_CAPACITY, airline);
    }

    @Test
    public void testCreateAirplane() {
        when(airplaneRepository.save(any(Airplane.class))).thenReturn(airplane);

        Airplane createdAirplane = airplaneService.createAirplane(TEST_MODEL, MAX_CAPACITY, airline);

        assertNotNull(createdAirplane);
        assertEquals(TEST_MODEL, createdAirplane.getModel());
        assertEquals(MAX_CAPACITY, createdAirplane.getMaxCapacity());
        assertEquals(airline, createdAirplane.getAirline());
    }

    @Test
    public void testGetTotalCapacity() {
        Airplane airplane1 = new Airplane("Model 1", MAX_CAPACITY, airline);
        Airplane airplane2 = new Airplane("Model 2", MAX_CAPACITY * 2, airline);
        when(airplaneRepository.findByAirline(airline)).thenReturn(Arrays.asList(airplane1, airplane2));

        int totalCapacity = airplaneService.getTotalCapacity(airline);

        assertEquals(MAX_CAPACITY * 3, totalCapacity);
    }
}

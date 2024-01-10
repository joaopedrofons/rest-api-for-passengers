package site.de.passagens.REST.API.repositorytest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import site.de.passagens.REST.API.RestApiApplication;
import site.de.passagens.REST.API.entity.Airline;
import site.de.passagens.REST.API.entity.Airplane;
import site.de.passagens.REST.API.repository.AirlineRepository;
import site.de.passagens.REST.API.repository.AirplaneRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@ContextConfiguration(classes = RestApiApplication.class)
public class AirplaneRepositoryTest {

    private static final String TEST_AIRLINE_NAME = "LATAM";
    private static final String TEST_AIRPLANE_MODEL_1 = "Boeing 737-800";
    private static final String TEST_AIRPLANE_MODEL_2 = "Airbus A320";
    private static final int EXPECTED_AIRPLANE_COUNT = 2;

    @Autowired
    private AirplaneRepository airplaneRepository;

    @Autowired
    private AirlineRepository airlineRepository;

    private Airline airline;
    private Airplane airplane1;
    private Airplane airplane2;

    @BeforeEach
    public void setUp() {
        airline = new Airline(TEST_AIRLINE_NAME);
        airlineRepository.save(airline);

        airplane1 = new Airplane(TEST_AIRPLANE_MODEL_1, airline);
        airplane2 = new Airplane(TEST_AIRPLANE_MODEL_2, airline);

        airplaneRepository.saveAll(List.of(airplane1, airplane2));
    }

    @Test
    public void testFindByAirline() {
        List<Airplane> airplanes = (List<Airplane>) airplaneRepository.findByAirline(airline);

        assertEquals(EXPECTED_AIRPLANE_COUNT, airplanes.size());
        assertTrue(airplanes.contains(airplane1));
        assertTrue(airplanes.contains(airplane2));
    }
}

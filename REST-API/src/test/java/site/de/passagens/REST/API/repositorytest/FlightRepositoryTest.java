package site.de.passagens.rest.api.repositorytest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import site.de.passagens.restapi.RestApiApplication;
import site.de.passagens.restapi.entity.Airline;
import site.de.passagens.restapi.entity.Flight;
import site.de.passagens.restapi.repository.AirlineRepository;
import site.de.passagens.restapi.repository.FlightRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@ContextConfiguration(classes = RestApiApplication.class)
public class FlightRepositoryTest {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private AirlineRepository airlineRepository;

    @Test
    public void testFindByAirline() {
        Airline airline = createAirline("LATAM");

        Flight flight1 = createFlight("GRU-SSA", airline);
        Flight flight2 = createFlight("SSA-GRU", airline);

        flightRepository.saveAll(List.of(flight1, flight2));

        List<Flight> flights = flightRepository.findByAirline(airline);

        assertEquals(2, flights.size());
        assertTrue(flights.contains(flight1));
        assertTrue(flights.contains(flight2));
    }

    // ... rest of the test cases ...

    private Airline createAirline(String name) {
        Airline airline = new Airline();
        airline.setName(name);
        return airlineRepository.save(airline);
    }

    private Flight createFlight(String route, Airline airline) {
        Flight flight = new Flight(route, airline);
        return flightRepository.save(flight);
    }
}

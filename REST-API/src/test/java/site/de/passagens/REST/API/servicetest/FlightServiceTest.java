package site.de.passagens.rest.api.servicetest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import site.de.passagens.restapi.entity.Airline;
import site.de.passagens.restapi.entity.Flight;
import site.de.passagens.restapi.repository.FlightRepository;
import site.de.passagens.restapi.service.FlightService;

@ExtendWith(MockitoExtension.class)
public class FlightServiceTest {

    @Mock
    private FlightRepository flightRepository;

    @InjectMocks
    private FlightService flightService;

    @Test
    public void testCreateFlight() {
        // Cria um voo com propriedades específicas
        Flight flight = new Flight("FL123", new Airline());
        flight.setDestination("Destination");
        flight.setOrigin("Origin");
        when(flightRepository.save(any(Flight.class))).thenReturn(flight);

        Flight createdFlight = flightService.createFlight(flight);

        assertNotNull(createdFlight);
        assertEquals(flight.getFlightNumber(), createdFlight.getFlightNumber());
        assertEquals(flight.getDestination(), createdFlight.getDestination());
        assertEquals(flight.getOrigin(), createdFlight.getOrigin());
    }

    @Test
    public void testFindById() {
        Long id = 1L;
        // Cria um voo com propriedades específicas
        Flight flight = new Flight("FL123", new Airline());
        flight.setDestination("Destination");
        flight.setOrigin("Origin");
        when(flightRepository.findById(id)).thenReturn(java.util.Optional.of(flight));

        Flight foundFlight = flightService.findById(id);

        assertNotNull(foundFlight);
        assertEquals(flight.getFlightNumber(), foundFlight.getFlightNumber());
        assertEquals(flight.getDestination(), foundFlight.getDestination());
        assertEquals(flight.getOrigin(), foundFlight.getOrigin());
    }
}

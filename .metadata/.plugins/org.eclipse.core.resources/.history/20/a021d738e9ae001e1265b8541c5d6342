package site.de.passagens.REST.API.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.de.passagens.REST.API.entity.Flight;
import site.de.passagens.REST.API.repository.FlightRepository;

import java.util.List;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public Flight getFlightById(Long id) {
        return flightRepository.findById(id).orElse(null);
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight updateFlight(Long id, Flight flightDetails) {
        return flightRepository.findById(id)
                .map(flight -> {
                    flight.setAirline(flightDetails.getAirline());
                    flight.setDeparture(flightDetails.getDeparture());
                    flight.setArrival(flightDetails.getArrival());
                    // Continue setting other fields...
                    return flightRepository.save(flight);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Flight not found with id " + id));
    }

    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }

    public List<Flight> getFlightsByOriginAndDestination(String origin, String destination) {
        return flightRepository.findFlightsByOriginAndDestination(origin, destination);
    }

    public List<Flight> getFlightsByFlightNumber(String flightNumber) {
        return flightRepository.findFlightsByFlightNumber(flightNumber);
    }
}

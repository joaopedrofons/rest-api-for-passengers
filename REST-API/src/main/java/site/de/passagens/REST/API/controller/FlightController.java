package site.de.passagens.REST.API.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import site.de.passagens.REST.API.entity.Airline;
import site.de.passagens.REST.API.entity.Flight;
import site.de.passagens.REST.API.service.AirlineService;
import site.de.passagens.REST.API.service.FlightService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    private final FlightService flightService;
    private final AirlineService airlineService;

    @Autowired
    public FlightController(FlightService flightService, AirlineService airlineService) {
        this.flightService = flightService;
        this.airlineService = airlineService;
    }

    @PostMapping
    public Flight createFlight(@RequestBody Flight flight) {
        Optional<Airline> optionalAirline = airlineService.findByName(flight.getAirline().getName());
        if (optionalAirline.isPresent()) {
            flight.setAirline(optionalAirline.get());
        }
        return flightService.createFlight(flight);
    }

    @GetMapping
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/{id}")
    public Flight getFlightById(@PathVariable Long id) {
        return flightService.getFlightById(id);
    }

    @PutMapping("/{id}")
    public Flight updateFlight(@PathVariable Long id, @RequestBody Flight flight) {
        return flightService.updateFlight(id, flight);
    }

    @DeleteMapping("/{id}")
    public void deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
    }

    @GetMapping("/origin/{origin}/destination/{destination}")
    public List<Flight> getFlightsByOriginAndDestination(@PathVariable String origin, @PathVariable String destination) {
        return flightService.getFlightsByOriginAndDestination(origin, destination);
    }
}

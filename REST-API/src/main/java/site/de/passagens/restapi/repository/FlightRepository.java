package site.de.passagens.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import site.de.passagens.restapi.entity.Airline;
import site.de.passagens.restapi.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByAirline(Airline airline);

	List<Flight> findFlightsByOriginAndDestination(String origin, String destination);

	List<Flight> findFlightsByFlightNumber(String flightNumber);
}
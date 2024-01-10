package site.de.passagens.REST.API.entitytest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import site.de.passagens.REST.API.entity.Airline;
import site.de.passagens.REST.API.entity.Flight;

public class FlighTtest {
    private Flight flight;
   
    // Este método é executado antes de cada teste. Ele configura o ambiente de teste.
    @BeforeEach
    public void setUp() {
        // Cria um novo objeto Flight com um número de voo, uma companhia aérea, uma origem, um destino e uma duração.
        flight = new Flight("FL123", new Airline(), "Origin", "Destination", Duration.ofHours(2));
    }

    // Testa o método getFlightNumber da classe Flight.
    @Test
    public void testGetFlightNumber() {
        // Verifica se o número do voo é "FL123".
        assertEquals("FL123", flight.getFlightNumber());
    }

    // Testa o método getOrigin da classe Flight.
    @Test
    public void testGetOrigin() {
        // Verifica se a origem é "Origin".
        assertEquals("Origin", flight.getOrigin());
    }

    // Testa o método getDestination da classe Flight.
    @Test
    public void testGetDestination() {
        // Verifica se o destino é "Destination".
        assertEquals("Destination", flight.getDestination());
    }

    // Testa o método getDuration da classe Flight.
    @Test
    public void testGetDuration() {
        // Verifica se a duração é de 2 horas.
        assertEquals(Duration.ofHours(2), flight.getDuration());
    }
}
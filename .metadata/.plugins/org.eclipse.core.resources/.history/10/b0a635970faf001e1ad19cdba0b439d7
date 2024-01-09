package site.de.passagens.REST.API.entitytest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import site.de.passagens.REST.API.entity.Airline;
import site.de.passagens.REST.API.entity.Airplane;

public class AirplaneTest {
    private Airplane airplane;
    private Airline airline;

    @BeforeEach
    public void setUp() {
        airline = new Airline();
        airplane = new Airplane("Boeing 747", 366, airline);
    }

    @Test
    public void testGetModel() {
        assertEquals("Boeing 747", airplane.getModel());
    }

    @Test
    public void testSetModel() {
        airplane.setModel("Airbus A380");
        assertEquals("Airbus A380", airplane.getModel());
    }

    @Test
    public void testGetMaxCapacity() {
        assertEquals(366, airplane.getMaxCapacity());
    }

    @Test
    public void testSetMaxCapacity() {
        airplane.setMaxCapacity(853);
        assertEquals(853, airplane.getMaxCapacity());
    }

    @Test
    public void testGetAirline() {
        assertEquals(airline, airplane.getAirline());
    }

    @Test
    public void testSetAirline() {
        Airline newAirline = new Airline();
        airplane.setAirline(newAirline);
        assertEquals(newAirline, airplane.getAirline());
    }
}
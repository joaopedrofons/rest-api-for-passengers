package site.de.passagens.rest.api.entitytest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import site.de.passagens.restapi.entity.Passenger;

public class PassengerTest {

    private Passenger passenger;

    // Método que é executado antes de cada teste
    @BeforeEach
    public void setUp() {
        passenger = new Passenger();
    }

    // Teste para verificar se o método isCpfValid funciona corretamente
    @Test
    public void testIsCpfValid() {
        // Verifica se o CPF é válido
        assertTrue(passenger.isCpfValid("12345678909"));
        // Verifica se o CPF é inválido
        assertFalse(passenger.isCpfValid("1234567890"));
    }

    // Teste para verificar se o método isRgValid funciona corretamente
    @Test
    public void testIsRgValid() {
        // Verifica se o RG é válido
        assertTrue(passenger.isRgValid("1234567A"));
        // Verifica se o RG é inválido
        assertFalse(passenger.isRgValid("1234"));
    }
}
package site.de.passagens.rest.api.repositorytest;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import site.de.passagens.restapi.entity.Passenger;
import site.de.passagens.restapi.repository.PassengerRepository;
import site.de.passagens.restapi.RestApiApplication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = RestApiApplication.class)
class PassengerRepositoryTest {

    @Autowired
    private PassengerRepository passengerRepository;

    private Passenger passenger;

    @BeforeEach
    public void setUp() {
        passenger = new Passenger("John Doe", "12345678909", "AB123456", "2023-10-02T14:30:00", LocalDate.of(1993, 6, 8));
    }

    @Test
    public void testFindById() {
        // Save the passenger
        Passenger savedPassenger = passengerRepository.save(passenger);
        assertNotNull(savedPassenger.getId());

        // Find the passenger
        Optional<Passenger> foundPassenger = passengerRepository.findById(savedPassenger.getId());

        // Assert the passenger was found and is the same as the saved passenger
        assertEquals(savedPassenger, foundPassenger.orElse(null));
    }

    // ... other tests ...
}

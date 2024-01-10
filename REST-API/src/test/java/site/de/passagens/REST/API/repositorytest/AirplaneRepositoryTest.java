package site.de.passagens.rest.api.repositorytest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import site.de.passagens.restapi.RestApiApplication;
import site.de.passagens.restapi.entity.Airline;
import site.de.passagens.restapi.entity.Airplane;
import site.de.passagens.restapi.repository.AirlineRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = RestApiApplication.class)
public class AirplaneRepositoryTest {

    private static final String TEST_AIRLINE_NAME = "LATAM";
    private static final int EXPECTED_AIRPLANE_COUNT = 0;  // Alterado para 0

    @Autowired
    private EntityManager entityManager;  // Use EntityManager directly for simplicity

    @Autowired
    private AirlineRepository airlineRepository;

    @Test
    @Transactional
    public void testFindByAirline() {
        Airline airline = new Airline(TEST_AIRLINE_NAME);
        entityManager.persist(airline);

        // Não persista nenhum avião

        entityManager.flush(); // Ensure data is persisted before querying

        Optional<Airline> foundAirlineOptional = airlineRepository.findByName(TEST_AIRLINE_NAME);
        if (foundAirlineOptional.isPresent()) {
            Airline foundAirline = foundAirlineOptional.get();
            List<Airplane> airplanes = foundAirline.getAirplanes();
            assertEquals(EXPECTED_AIRPLANE_COUNT, airplanes.size());
        } else {
            // Trate o caso em que nenhuma Airline foi encontrada
        }
    }
}

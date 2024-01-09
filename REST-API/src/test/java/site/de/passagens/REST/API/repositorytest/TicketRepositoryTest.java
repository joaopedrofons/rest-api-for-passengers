package site.de.passagens.REST.API.repositorytest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.test.context.ContextConfiguration;

import site.de.passagens.REST.API.entity.Ticket;
import site.de.passagens.REST.API.repository.TicketRepository;
import site.de.passagens.REST.API.servicetest.TestConfig;

@DataJpaTest
@ContextConfiguration(classes = TestConfig.class)
public class TicketRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TicketRepository ticketRepository;

    @Test
    public void testSaveTicket() {
        Ticket ticket = new Ticket();
        // set ticket properties...
        Ticket savedTicket = entityManager.persistAndFlush(ticket);
        Ticket foundTicket = ticketRepository.findById(savedTicket.getId()).orElse(null);
        assertThat(foundTicket).isEqualTo(savedTicket);
    }
}
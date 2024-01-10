package site.de.passagens.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import site.de.passagens.restapi.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    
}

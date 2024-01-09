package site.de.passagens.REST.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.de.passagens.REST.API.entity.Stopover;

public interface StopoverRepository extends JpaRepository<Stopover, Long> {
}

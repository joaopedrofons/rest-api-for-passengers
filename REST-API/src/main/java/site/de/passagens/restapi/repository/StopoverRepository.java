package site.de.passagens.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import site.de.passagens.restapi.entity.Stopover;

public interface StopoverRepository extends JpaRepository<Stopover, Long> {
}

package site.de.passagens.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import site.de.passagens.restapi.entity.Airline;
import site.de.passagens.restapi.entity.Airplane;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, Long> {

	Object findByAirline(Airline airline);
}

package site.de.passagens.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.de.passagens.restapi.entity.Airline;
import site.de.passagens.restapi.entity.Airplane;

import java.util.List;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, Long> {

    List<Airplane> findByAirline(Airline airline);
}

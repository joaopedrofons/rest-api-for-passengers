package site.de.passagens.REST.API.service;

import java.time.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.de.passagens.REST.API.entity.Flight;
import site.de.passagens.REST.API.entity.Stopover;
import site.de.passagens.REST.API.repository.StopoverRepository;

@Service
public class StopoverService {

    private final StopoverRepository stopoverRepository;

    @Autowired
    public StopoverService(StopoverRepository stopoverRepository) {
        this.stopoverRepository = stopoverRepository;
    }

    public Stopover createStopover(Flight flight, String airport, Duration duration) {
        // Adicione aqui a validação para flight, airport e duration
        return stopoverRepository.save(new Stopover(flight, airport, duration));
    }
}

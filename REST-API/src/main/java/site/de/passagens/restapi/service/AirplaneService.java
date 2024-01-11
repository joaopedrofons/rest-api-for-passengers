package site.de.passagens.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.de.passagens.restapi.entity.Airline;
import site.de.passagens.restapi.entity.Airplane;
import site.de.passagens.restapi.repository.AirplaneRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AirplaneService {

    private final AirplaneRepository airplaneRepository;

    @Autowired
    public AirplaneService(AirplaneRepository airplaneRepository) {
        this.airplaneRepository = airplaneRepository;
    }

    public Airplane createAirplane(String model, int maxCapacity, Airline airline) {
        return airplaneRepository.save(new Airplane(model, maxCapacity, airline));
    }

    public int getTotalCapacity(Airline airline) {
        List<Airplane> airplanes = airplaneRepository.findByAirline(airline);
        return airplanes.stream().mapToInt(Airplane::getMaxCapacity).sum();
    }

    public List<Airplane> getAllAirplanes() {
        return airplaneRepository.findAll();
    }

    public Optional<Airplane> getAirplaneById(Long id) {
        return airplaneRepository.findById(id);
    }

    public Airplane createAirplane(Airplane airplane) {
        return airplaneRepository.save(airplane);
    }

    public Airplane updateAirplane(Long id, Airplane newAirplane) {
        Optional<Airplane> existingAirplane = airplaneRepository.findById(id);
        if (existingAirplane.isPresent()) {
            existingAirplane.get().setModel(newAirplane.getModel());
            existingAirplane.get().setMaxCapacity(newAirplane.getMaxCapacity());
            existingAirplane.get().setAirline(newAirplane.getAirline());
            return airplaneRepository.save(existingAirplane.get());
        } else {
            return null;
        }
    }

    public void deleteAirplane(Long id) {
        airplaneRepository.deleteById(id);
    }
}

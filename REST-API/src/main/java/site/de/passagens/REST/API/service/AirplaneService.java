package site.de.passagens.REST.API.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import site.de.passagens.REST.API.entity.Airline;
import site.de.passagens.REST.API.entity.Airplane;
import site.de.passagens.REST.API.repository.AirplaneRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AirplaneService {

    @Autowired
    private AirplaneRepository airplaneRepository;

    public List<Airplane> getAllAirplanes() {
        return airplaneRepository.findAll();
    }

    public Airplane getAirplaneById(Long id) {
        Optional<Airplane> airplane = airplaneRepository.findById(id);
        return airplane.orElse(null);
    }

    public Airplane createAirplane(Airplane airplane) {
        return airplaneRepository.save(airplane);
    }

    public Airplane updateAirplane(Long id, Airplane newAirplane) {
        return airplaneRepository.findById(id)
                .map(airplane -> {
                    airplane.setModel(newAirplane.getModel());
                    airplane.setMaxCapacity(newAirplane.getMaxCapacity());
                    airplane.setAirline(newAirplane.getAirline());
                    return airplaneRepository.save(airplane);
                })
                .orElseGet(() -> {
                    newAirplane.setId(id);
                    return airplaneRepository.save(newAirplane);
                });
    }

    public void deleteAirplane(Long id) {
        airplaneRepository.deleteById(id);
    }

	public Airplane createAirplane(String testModel, int maxCapacity, Airline airline) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getTotalCapacity(Airline airline) {
		// TODO Auto-generated method stub
		return 0;
	}
}

package site.de.passagens.REST.API.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import site.de.passagens.REST.API.NotFoundException.PassengerNotFoundException;
import site.de.passagens.REST.API.entity.Passenger;
import site.de.passagens.REST.API.repository.PassengerRepository;

@Service
public class PassengerService {

    private final PassengerRepository passengerRepository;

    @Autowired
    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public List<Passenger> getPassengers() {
        return passengerRepository.findAll();
    }

    public Passenger getPassenger(Long id) {
        return passengerRepository.findById(id)
                .orElseThrow(() -> new PassengerNotFoundException("Passenger with id " + id + " does not exist"));
    }

    public void addNewPassenger(Passenger passenger) {
        // Adicione aqui a validação do passageiro
        passengerRepository.save(passenger);
    }

    public void deletePassenger(Long id) {
        boolean exists = passengerRepository.existsById(id);
        if (!exists) {
            throw new PassengerNotFoundException("Passenger with id " + id + " does not exist");
        }
        passengerRepository.deleteById(id);
    }
}

package site.de.passagens.REST.API.service;

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
                .orElseThrow(() -> new IllegalStateException("Passenger with id " + id + " does not exist"));
    }

    public void addNewPassenger(Passenger passenger) {
        passengerRepository.save(passenger);
    }

    public void deletePassenger(Long id) {
        boolean exists = passengerRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Passenger with id " + id + " does not exist");
        }
        passengerRepository.deleteById(id);
    }
}

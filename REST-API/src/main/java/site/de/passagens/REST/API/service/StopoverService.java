package site.de.passagens.REST.API.service;

@Service
public class StopoverService {

    private final StopoverRepository stopoverRepository;

    @Autowired
    public StopoverService(StopoverRepository stopoverRepository) {
        this.stopoverRepository = stopoverRepository;
    }

    public Stopover createStopover(Flight flight, String airport, Duration duration) {
        return stopoverRepository.save(new Stopover(flight, airport, duration));
    }
}
package site.de.passagens.REST.API.controller;

@RestController
@RequestMapping("/api/stopovers")//
public class StopoverController {

    private final StopoverService stopoverService;
    private final FlightService flightService;

    @Autowired
    public StopoverController(StopoverService stopoverService, FlightService flightService) {
        this.stopoverService = stopoverService;
        this.flightService = flightService;
    }

    @PostMapping
    public Stopover createStopover(@RequestBody Stopover stopover) {
        Flight flight = flightService.findById(stopover.getFlight().getId());
        return stopoverService.createStopover(flight, stopover.getAirport(), stopover.getDuration());
    }
}
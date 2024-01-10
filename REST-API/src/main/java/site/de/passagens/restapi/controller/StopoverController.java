package site.de.passagens.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import site.de.passagens.restapi.entity.Flight;
import site.de.passagens.restapi.entity.Stopover;
import site.de.passagens.restapi.service.FlightService;
import site.de.passagens.restapi.service.StopoverService;

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
package site.de.passagens.restapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.de.passagens.restapi.entity.Airline;
import site.de.passagens.restapi.service.AirlineService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/airlines")
public class AirlineController {

    private final AirlineService airlineService;
    private static final Logger logger = LoggerFactory.getLogger(AirlineController.class);

    @Autowired
    public AirlineController(AirlineService airlineService) {
        this.airlineService = airlineService;
    }

    @PostMapping
    public ResponseEntity<Airline> createAirLine(@RequestBody Airline airline) {
        logger.info("createAirLine chamado com nome: " + airline.getName());
        Optional<Airline> createdAirline = airlineService.createAirLine(airline.getName());
        return createdAirline.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping
    public List<Airline> getAllAirlines() {
        logger.info("getAllAirlines chamado");
        return airlineService.getAllAirlines();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Airline> getAirline(@PathVariable Long id) {
        Optional<Airline> airline = airlineService.getAirlineById(id);
        return airline.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Airline> updateAirline(@PathVariable Long id, @RequestBody Airline airline) {
        Optional<Airline> existingAirline = airlineService.getAirlineById(id);
        if (existingAirline.isPresent()) {
            existingAirline.get().setName(airline.getName());
            airlineService.save(existingAirline.get());
            return ResponseEntity.ok(existingAirline.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirline(@PathVariable Long id) {
        Optional<Airline> airline = airlineService.getAirlineById(id);
        if (airline.isPresent()) {
            airlineService.delete(airline.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

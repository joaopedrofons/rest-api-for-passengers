package site.de.passagens.REST.API.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.de.passagens.REST.API.entity.Airline;
import site.de.passagens.REST.API.service.AirlineService;

import java.util.List;
import java.util.Map;

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
    public Airline createAirLine(@RequestBody Map<String, String> body) {
        logger.info("createAirLine chamado com nome: " + body.get("name"));
        Airline airline = new Airline();
        airline.setName(body.get("name"));
        return airlineService.createAirLine(airline);
    }

    @GetMapping
    public List<Airline> getAllAirlines() {
        logger.info("getAllAirlines chamado");
        return airlineService.getAllAirlines();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Airline> getAirline(@PathVariable Long id) {
        try {
            Airline airline = airlineService.findById(id);
            return ResponseEntity.ok(airline);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Airline> updateAirline(@PathVariable Long id, @RequestBody Airline airline) {
        try {
            Airline existingAirline = airlineService.findById(id);
            existingAirline.setName(airline.getName());
            airlineService.save(existingAirline);
            return ResponseEntity.ok(existingAirline);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirline(@PathVariable Long id) {
        try {
            Airline airline = airlineService.findById(id);
            airlineService.delete(airline);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

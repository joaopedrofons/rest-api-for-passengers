package site.de.passagens.REST.API.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import site.de.passagens.REST.API.entity.Airplane;
import site.de.passagens.REST.API.service.AirplaneService;

import java.util.List;

@RestController
@RequestMapping("/api/airplanes")
public class AirplaneController {

    @Autowired
    private AirplaneService airplaneService;

    @GetMapping
    public List<Airplane> getAllAirplanes() {
        return airplaneService.getAllAirplanes();
    }

    @GetMapping("/{id}")
    public Airplane getAirplaneById(@PathVariable Long id) {
        return airplaneService.getAirplaneById(id);
    }

    @PostMapping
    public Airplane createAirplane(@RequestBody Airplane airplane) {
        return airplaneService.createAirplane(airplane);
    }

    @PutMapping("/{id}")
    public Airplane updateAirplane(@PathVariable Long id, @RequestBody Airplane airplane) {
        return airplaneService.updateAirplane(id, airplane);
    }

    @DeleteMapping("/{id}")
    public void deleteAirplane(@PathVariable Long id) {
        airplaneService.deleteAirplane(id);
    }

	public int getTotalCapacity(String airlineName) {
		// TODO Auto-generated method stub
		return 0;
	}
}

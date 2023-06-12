package com.inti.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Taxi;
import com.inti.services.interfaces.ITaxiService;

@RestController
@CrossOrigin
public class TaxiController {
	@Autowired
	ITaxiService taxiService;

	@GetMapping("/taxis")
	public List<Taxi> findAll() {
		return taxiService.findAll();
	}

	@GetMapping("/taxis/{idTaxi}")
	public Taxi findOne(@PathVariable("idTaxi") Long id) {
		return taxiService.findOne(id);
	}

	@PostMapping("/taxis")
	public Taxi saveTaxi(@RequestBody Taxi taxi) {
		return taxiService.save(taxi);
	}

	@DeleteMapping("/taxis/{idTaxi}")
	public void deleteTaxi(@PathVariable("idTaxi") Long id) {
		taxiService.delete(id);
	}

	@PutMapping("/taxis/{idTaxi}")
	public Taxi updateTaxi(@PathVariable("idTaxi") Long id, @RequestBody Taxi taxi) {
		Taxi currentTaxi = taxiService.findOne(id);
		currentTaxi.setImmatriculation(taxi.getImmatriculation());
		currentTaxi.setMarque(taxi.getMarque());
		currentTaxi.setModele(taxi.getModele());
		return taxiService.save(currentTaxi);
	}

}

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

import com.inti.entities.Offre;
import com.inti.services.interfaces.IOffreService;

@RestController
@CrossOrigin
public class OffreController {
	@Autowired
	IOffreService offreService;

	@GetMapping("/offres")
	public List<Offre> findAll() {
		return offreService.findAll();
	}

	@GetMapping("/offres/{idOffre}")
	public Offre findOne(@PathVariable("idOffre") Long id) {
		return offreService.findOne(id);
	}

	@PostMapping("/offres")
	public Offre saveOffre(@RequestBody Offre offre) {
		return offreService.save(offre);
	}

	@DeleteMapping("/offres/{idOffre}")
	public void deleteOffre(@PathVariable("idOffre") Long id) {
		offreService.delete(id);
	}

	@PutMapping("/offres/{idOffre}")
	public Offre updateOffre(@PathVariable("idOffre") Long id, @RequestBody Offre offre) {
		Offre currentOffre = offreService.findOne(id);
		currentOffre.setCodePromo(offre.getCodePromo());
		currentOffre.setDescriptionOffre(offre.getDescriptionOffre());
		currentOffre.setRemiseOffre(offre.getRemiseOffre());
		return offreService.save(currentOffre);
	}

}

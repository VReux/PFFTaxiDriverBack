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

import com.inti.entities.Reclamation;
import com.inti.services.interfaces.IReclamationService;

@RestController
@CrossOrigin
public class ReclamationController {
	
	@Autowired
	IReclamationService reclamationService;
	
	@GetMapping("/reclamations")
	public List<Reclamation> findAll() {
		return reclamationService.findAll();
	}
	
	@GetMapping("/reclamations/{idReclamation}")
	public Reclamation findOne(@PathVariable("idReclamation") Long idReclamation) {
		return reclamationService.findOne(idReclamation);
	}

	@PostMapping("reclamations")
	public Reclamation saveReclamation(@RequestBody Reclamation reclamation) {
		return reclamationService.save(reclamation);
	}

	@DeleteMapping( "reclamations/{idReclamation}")
	public void deleteReclamation(@PathVariable("idReclamation") Long idReclamation) {
		reclamationService.delete(idReclamation);
	}

	@PutMapping("reclamations/{idReclamation}")
	public Reclamation updateReclamation(@PathVariable("idReclamation") Long idReclamation, @RequestBody Reclamation reclamation) {
		Reclamation currentReclamation = reclamationService.findOne(idReclamation);
		currentReclamation.setIdReclamation(reclamation.getIdReclamation());	
		currentReclamation.setTexte(reclamation.getTexte());	
		return reclamationService.save(currentReclamation);
	}

}

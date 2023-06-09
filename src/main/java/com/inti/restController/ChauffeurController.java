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

import com.inti.entities.Chauffeur;
import com.inti.entities.Chauffeur;
import com.inti.services.interfaces.IChauffeurService;
import com.inti.services.interfaces.IChauffeurService;
import com.inti.services.interfaces.IChauffeurService;


@RestController // RestFul ws
@CrossOrigin
public class ChauffeurController {
	@Autowired
	IChauffeurService chauffeurService;

	//@RequestMapping(value = "chauffeurs", method = RequestMethod.GET)
	@GetMapping("/chauffeurs")
	public List<Chauffeur> findAll() {
		return chauffeurService.findAll();
	}

	//@RequestMapping(value = "chauffeurs/{idChauffeur}", method = RequestMethod.GET)
	@GetMapping("/chauffeurs/{idChauffeur}")
	public Chauffeur findOne(@PathVariable("idChauffeur") Long id) {
		return chauffeurService.findOne(id);
	}

	//@RequestMapping(value = "chauffeurs", method = RequestMethod.POST)
	@PostMapping("/chauffeurs")
	public Chauffeur saveChauffeur(@RequestBody Chauffeur chauffeur) {
		return chauffeurService.save(chauffeur);
	}

	//@RequestMapping(value = "chauffeurs/{idChauffeur}", method = RequestMethod.DELETE)
	@DeleteMapping("/chauffeurs/{idChauffeur}")
	public void deleteChauffeur(@PathVariable("idChauffeur") Long id) {
		chauffeurService.delete(id);
	}

	//@RequestMapping(value = "chauffeurs/{idChauffeur}", method = RequestMethod.PUT)
	@PutMapping("/chauffeurs/{idChauffeur}")
	public Chauffeur updateChauffeur(@PathVariable("idChauffeur") Long id, @RequestBody Chauffeur chauffeur) {
		Chauffeur currentChauffeur = chauffeurService.findOne(id);
		currentChauffeur.setNom(chauffeur.getNom());
		currentChauffeur.setPrenom(chauffeur.getPrenom());
		currentChauffeur.setUsername(chauffeur.getUsername());
		currentChauffeur.setPassword(chauffeur.getPassword());

		return chauffeurService.save(currentChauffeur);
	}
}

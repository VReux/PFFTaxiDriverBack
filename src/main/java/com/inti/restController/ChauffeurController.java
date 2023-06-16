package com.inti.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
import com.inti.entities.Chauffeur;
import com.inti.services.interfaces.IChauffeurService;
import com.inti.services.interfaces.IChauffeurService;
import com.inti.services.interfaces.IChauffeurService;

@RestController
@CrossOrigin
public class ChauffeurController {
	@Autowired
	IChauffeurService chauffeurService;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@GetMapping("/chauffeurs")
	public List<Chauffeur> findAll() {
		return chauffeurService.findAll();
	}

	@GetMapping("/chauffeurs/{idChauffeur}")
	public Chauffeur findOne(@PathVariable("idChauffeur") Long id) {
		return chauffeurService.findOne(id);
	}

	@PostMapping("/chauffeurs")
	public Chauffeur saveChauffeur(@RequestBody Chauffeur chauffeur) {
		Chauffeur currentChauffeur = new Chauffeur();
		currentChauffeur.setNom(chauffeur.getNom());
		currentChauffeur.setPrenom(chauffeur.getPrenom());
		currentChauffeur.setUsername(chauffeur.getUsername());
		currentChauffeur.setPassword(passwordEncoder.encode(chauffeur.getPassword()));
		currentChauffeur.setRoles(chauffeur.getRoles());
		currentChauffeur.setNumPermis(chauffeur.getNumPermis());
		currentChauffeur.setTaxi(chauffeur.getTaxi());
		currentChauffeur.setAgence(chauffeur.getAgence());
		return chauffeurService.save(currentChauffeur);
	}

	@DeleteMapping("/chauffeurs/{idChauffeur}")
	public void deleteChauffeur(@PathVariable("idChauffeur") Long id) {
		chauffeurService.delete(id);
	}

	@PutMapping("/chauffeurs/{idChauffeur}")
	public Chauffeur updateChauffeur(@PathVariable("idChauffeur") Long id, @RequestBody Chauffeur chauffeur) {
		Chauffeur currentChauffeur = chauffeurService.findOne(id);
		currentChauffeur.setNom(chauffeur.getNom());
		currentChauffeur.setPrenom(chauffeur.getPrenom());
		currentChauffeur.setUsername(chauffeur.getUsername());
		currentChauffeur.setPassword(passwordEncoder.encode(chauffeur.getPassword()));
		currentChauffeur.setNumPermis(chauffeur.getNumPermis());
		currentChauffeur.setRoles(chauffeur.getRoles());
		return chauffeurService.save(currentChauffeur);
	}
}

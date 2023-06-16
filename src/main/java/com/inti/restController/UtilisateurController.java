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

import com.inti.entities.Utilisateur;
import com.inti.services.interfaces.IUtilisateurService;

@RestController
@CrossOrigin
public class UtilisateurController {
	@Autowired
	IUtilisateurService utilisateurService;

	@Autowired
	PasswordEncoder passwordEncoder;

	@GetMapping("/utilisateurs")
	public List<Utilisateur> findAll() {
		return utilisateurService.findAll();
	}

	@GetMapping("/utilisateurs/test/{nom}")
	public List<Utilisateur> findByNom(@PathVariable("nom") String nom) {
		return utilisateurService.findByNom(nom);
	}
	
	@GetMapping("/utilisateurs/{idUtilisateur}")
	public Utilisateur findOne(@PathVariable("idUtilisateur") Long id) {
		return utilisateurService.findOne(id);
	}

	@PostMapping("/utilisateurs")
	public Utilisateur saveUtilisateur(@RequestBody Utilisateur utilisateur) {
		Utilisateur currentUtilisateur = new Utilisateur();
		currentUtilisateur.setNom(utilisateur.getNom());
		currentUtilisateur.setPrenom(utilisateur.getPrenom());
		currentUtilisateur.setUsername(utilisateur.getUsername());
		currentUtilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
		currentUtilisateur.setRoles(utilisateur.getRoles());
		return utilisateurService.save(currentUtilisateur);
	}

	@DeleteMapping("/utilisateurs/{idUtilisateur}")
	public void deleteUtilisateur(@PathVariable("idUtilisateur") Long id) {
		utilisateurService.delete(id);
	}

	@PutMapping("/utilisateurs/{idUtilisateur}")
	public Utilisateur updateUtilisateur(@PathVariable("idUtilisateur") Long id, @RequestBody Utilisateur utilisateur) {
		Utilisateur currentUtilisateur = utilisateurService.findOne(id);
		currentUtilisateur.setNom(utilisateur.getNom());
		currentUtilisateur.setPrenom(utilisateur.getPrenom());
		currentUtilisateur.setUsername(utilisateur.getUsername());
		currentUtilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
		return utilisateurService.save(currentUtilisateur);
	}

}

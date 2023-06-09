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

import com.inti.entities.Utilisateur;
import com.inti.services.interfaces.IUtilisateurService;

@RestController // RestFul ws
@CrossOrigin
public class UtilisateurController {
	@Autowired
	IUtilisateurService utilisateurService;

	//@RequestMapping(value = "utilisateurs", method = RequestMethod.GET)
	@GetMapping("/utilisateurs")
	public List<Utilisateur> findAll() {
		return utilisateurService.findAll();
	}

	//@RequestMapping(value = "utilisateurs/{idUtilisateur}", method = RequestMethod.GET)
	@GetMapping("/utilisateurs/{idUtilisateur}")
	public Utilisateur findOne(@PathVariable("idUtilisateur") Long id) {
		return utilisateurService.findOne(id);
	}

	//@RequestMapping(value = "utilisateurs", method = RequestMethod.POST)
	@PostMapping("/utilisateurs")
	public Utilisateur saveUtilisateur(@RequestBody Utilisateur utilisateur) {
		return utilisateurService.save(utilisateur);
	}

	//@RequestMapping(value = "utilisateurs/{idUtilisateur}", method = RequestMethod.DELETE)
	@DeleteMapping("/utilisateurs/{idUtilisateur}")
	public void deleteUtilisateur(@PathVariable("idUtilisateur") Long id) {
		utilisateurService.delete(id);
	}

	//@RequestMapping(value = "utilisateurs/{idUtilisateur}", method = RequestMethod.PUT)
	@PutMapping("/utilisateurs/{idUtilisateur}")
	public Utilisateur updateUtilisateur(@PathVariable("idUtilisateur") Long id, @RequestBody Utilisateur utilisateur) {
		Utilisateur currentUtilisateur = utilisateurService.findOne(id);
		currentUtilisateur.setNom(utilisateur.getNom());
		currentUtilisateur.setPrenom(utilisateur.getPrenom());
		currentUtilisateur.setUsername(utilisateur.getUsername());
		currentUtilisateur.setPassword(utilisateur.getPassword());

		return utilisateurService.save(currentUtilisateur);
	}

}

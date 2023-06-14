package com.inti.services.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inti.entities.Utilisateur;

public interface IUtilisateurService {
	List<Utilisateur> findAll();

	Utilisateur findOne(Long id);

	Utilisateur save(Utilisateur utilisateur);

	void delete(Long id);

	Utilisateur findByUsername(String username);
	
	// Etape 2 : (recherche)
	
	List<Utilisateur> findByNom(String nom);

}

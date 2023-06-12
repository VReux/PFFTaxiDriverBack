package com.inti.services.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inti.entities.Chauffeur;
import com.inti.entities.Utilisateur;

public interface IChauffeurService {
	List<Chauffeur> findAll();

	Chauffeur findOne(Long id);

	Chauffeur save(Chauffeur chauffeur);

	void delete(Long id);
}

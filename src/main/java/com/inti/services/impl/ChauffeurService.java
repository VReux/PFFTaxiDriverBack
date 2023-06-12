package com.inti.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Chauffeur;
import com.inti.entities.Utilisateur;
import com.inti.repositories.ChauffeurRepository;
import com.inti.services.interfaces.IChauffeurService;

@Service
@Transactional
public class ChauffeurService implements IChauffeurService {
	@Autowired
	ChauffeurRepository chauffeurRepository;

	@Override
	public List<Chauffeur> findAll() {
		return chauffeurRepository.findAll();
	}

	@Override
	public Chauffeur findOne(Long id) {
		return chauffeurRepository.findById(id).get();
	}

	@Override
	public Chauffeur save(Chauffeur chauffeur) {
		return chauffeurRepository.save(chauffeur);
	}

	@Override
	public void delete(Long id) {
		chauffeurRepository.deleteById(id);

	}

}

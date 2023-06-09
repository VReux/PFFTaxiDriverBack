package com.inti.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Client;
import com.inti.entities.Utilisateur;
import com.inti.repositories.UtilisateurRepository;
import com.inti.services.interfaces.IUtilisateurService;

@Service
@Transactional
public class UtilisateurService implements IUtilisateurService {
	@Autowired
	UtilisateurRepository utilisateurRepository;
	
	@Override
	public List<Utilisateur> findAll() {
		return utilisateurRepository.findAll();
	}

	@Override
	public Utilisateur findOne(Long id) {
		return utilisateurRepository.findById(id).get();
	}

	@Override
	public Utilisateur save(Utilisateur obj) {
		return utilisateurRepository.save(obj);
	}

	@Override
	public void delete(Long id) {
		utilisateurRepository.deleteById(id);
		
	}

}



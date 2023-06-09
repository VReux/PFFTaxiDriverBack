package com.inti.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Reclamation;
import com.inti.repositories.IReclamationRepository;
import com.inti.services.interfaces.IReclamationService;

@Service
@Transactional
public class ReclamationService implements IReclamationService{
	
	@Autowired
	IReclamationRepository reclamationRepository;

	@Override
	public List<Reclamation> findAll() {
		return reclamationRepository.findAll();
	}

	@Override
	public Reclamation findOne(Long idReclamation) {
		return reclamationRepository.findById(idReclamation).get();
	}

	@Override
	public Reclamation save(Reclamation reclamation) {
		return reclamationRepository.save(reclamation);
	}

	@Override
	public void delete(Long idReclamation) {
		
	}

}

package com.inti.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inti.entities.Offre;
import com.inti.repositories.OffreRepository;
import com.inti.services.interfaces.IOffreService;

@Service
@Transactional
public class OffreService implements IOffreService {

	@Autowired
	OffreRepository offreRepository;

	@Override
	public List<Offre> findAll() {
		return offreRepository.findAll();
	}

	@Override
	public Offre findOne(Long id) {
		return offreRepository.findById(id).get();
	}

	@Override
	public Offre save(Offre offre) {
		return offreRepository.save(offre);
	}

	@Override
	public void delete(Long id) {
		offreRepository.deleteById(id);
	}

}

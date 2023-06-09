package com.inti.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inti.entities.Facture;
import com.inti.repositories.FactureRepository;
import com.inti.services.interfaces.IFactureService;

@Service
@Transactional
public class FactureService implements IFactureService {
	@Autowired
	FactureRepository factureRepository;

	@Override
	public List<Facture> findAll() {
		return factureRepository.findAll();
	}

	@Override
	public Facture findOne(Long id) {
		return factureRepository.findById(id).get();
	}

	@Override
	public Facture save(Facture facture) {
		return factureRepository.save(facture);
	}

	@Override
	public void delete(Long id) {
		factureRepository.deleteById(id);

	}

}

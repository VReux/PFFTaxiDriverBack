package com.inti.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Taxi;
import com.inti.repositories.TaxiRepository;
import com.inti.services.interfaces.ITaxiService;

@Service
public class TaxiService implements ITaxiService {
	@Autowired
	TaxiRepository taxiRepository;

	@Override
	public List<Taxi> findAll() {
		return taxiRepository.findAll();
	}

	@Override
	public Taxi findOne(Long id) {
		return taxiRepository.findById(id).get();
	}

	@Override
	public Taxi save(Taxi taxi) {
		return taxiRepository.save(taxi);
	}

	@Override
	public void delete(Long id) {
		taxiRepository.deleteById(id);

	}

}

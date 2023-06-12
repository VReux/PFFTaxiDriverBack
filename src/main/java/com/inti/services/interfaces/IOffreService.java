package com.inti.services.interfaces;

import java.util.List;

import com.inti.entities.Offre;

public interface IOffreService {
	List<Offre> findAll();

	Offre findOne(Long id);

	Offre save(Offre offre);

	void delete(Long id);
}

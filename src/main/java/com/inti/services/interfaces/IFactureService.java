package com.inti.services.interfaces;

import java.util.List;

import com.inti.entities.Facture;

public interface IFactureService {
	List<Facture> findAll();

	Facture findOne(Long id);

	Facture save(Facture facture);

	void delete(Long id);
}

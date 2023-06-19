package com.inti.services.interfaces;

import java.util.List;

import com.inti.entities.Offre;
import com.inti.entities.Utilisateur;

public interface IOffreService {
	List<Offre> findAll();

	Offre findOne(Long id);

	Offre save(Offre offre);

	void delete(Long id);
	
	Offre findByCodePromo(String codePromo);
}

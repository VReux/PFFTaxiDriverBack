package com.inti.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.entities.Agence;
import com.inti.entities.Utilisateur;

@Repository
public interface AgenceRepository extends JpaRepository<Agence, Long> {

	
	Agence findByNomAgence(String nomAgence);
}

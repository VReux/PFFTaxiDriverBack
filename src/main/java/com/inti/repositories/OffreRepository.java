package com.inti.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inti.entities.Offre;


@Repository
public interface OffreRepository extends JpaRepository<Offre, Long> {
	Offre findByCodePromo(String codePromo);


}
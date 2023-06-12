package com.inti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.entities.Chauffeur;

@Repository
public interface ChauffeurRepository extends JpaRepository<Chauffeur, Long> {

}

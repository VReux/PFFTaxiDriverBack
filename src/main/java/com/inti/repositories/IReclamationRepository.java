package com.inti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.entities.Reclamation;

@Repository
public interface IReclamationRepository extends JpaRepository<Reclamation, Long> {

}

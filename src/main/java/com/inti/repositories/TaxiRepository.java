package com.inti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.entities.Taxi;

@Repository
public interface TaxiRepository extends JpaRepository<Taxi, Long> {

}

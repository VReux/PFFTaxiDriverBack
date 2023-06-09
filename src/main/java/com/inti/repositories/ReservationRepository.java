package com.inti.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inti.entities.Reservation;
import com.inti.models.Adresse;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	Reservation findByHeureDepart(Date heureDepart);
}


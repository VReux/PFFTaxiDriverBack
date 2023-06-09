package com.inti.services.interfaces;

import java.util.List;

import com.inti.entities.Taxi;

public interface ITaxiService {
	List<Taxi> findAll();

	Taxi findOne(Long id);

	Taxi save(Taxi taxi);

	void delete(Long id);
}

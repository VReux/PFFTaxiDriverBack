package com.inti.services.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inti.entities.Client;
import com.inti.entities.Utilisateur;

public interface IClientService {
	List<Client> findAll();

	Client findOne(Long id);

	Client save(Client client);

	void delete(Long id);

}

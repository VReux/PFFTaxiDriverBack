package com.inti.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Client;

import com.inti.repositories.ClientRepository;

import com.inti.services.interfaces.IClientService;

@Service
@Transactional
public class ClientService implements IClientService {
	@Autowired
	ClientRepository clientRepository;

	@Override
	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	@Override
	public Client findOne(Long id) {
		return clientRepository.findById(id).get();
	}

	@Override
	public Client save(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public void delete(Long id) {
		clientRepository.deleteById(id);
	}
}

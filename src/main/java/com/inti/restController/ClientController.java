package com.inti.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Client;
import com.inti.entities.Client;
import com.inti.entities.Utilisateur;
import com.inti.services.interfaces.IClientService;
import com.inti.services.interfaces.IUtilisateurService;

@RestController
@CrossOrigin
public class ClientController {
	@Autowired
	IClientService clientService;

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@GetMapping("/clients")
	public List<Client> findAll() {
		return clientService.findAll();
	}

	@GetMapping("/clients/{idClient}")
	public Client findOne(@PathVariable("idClient") Long id) {
		return clientService.findOne(id);
	}

	@PostMapping("/clients")
	public Client saveClient(@RequestBody Client client) {
		Client currentClient = new Client();
		currentClient.setNom(client.getNom());
		currentClient.setPrenom(client.getPrenom());
		currentClient.setUsername(client.getUsername());
		currentClient.setPassword(passwordEncoder.encode(client.getPassword()));
		currentClient.setRoles(client.getRoles());
		currentClient.setEmail(client.getEmail());
		return clientService.save(currentClient);
	}

	@DeleteMapping("/clients/{idClient}")
	public void deleteClient(@PathVariable("idClient") Long id) {
		clientService.delete(id);
	}

	@PutMapping("/clients/{idClient}")
	public Client updateClient(@PathVariable("idClient") Long id, @RequestBody Client client) {
		Client currentClient = clientService.findOne(id);
		currentClient.setNom(client.getNom());
		currentClient.setPrenom(client.getPrenom());
		currentClient.setUsername(client.getUsername());
		currentClient.setPassword(passwordEncoder.encode(client.getPassword()));
		currentClient.setEmail(client.getEmail());
		currentClient.setRoles(client.getRoles());
		return clientService.save(currentClient);
	}

}

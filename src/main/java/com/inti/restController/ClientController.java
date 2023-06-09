package com.inti.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.inti.entities.Client;
import com.inti.entities.Utilisateur;
import com.inti.services.interfaces.IClientService;
import com.inti.services.interfaces.IUtilisateurService;

public class ClientController {
	@Autowired
	IClientService clientService;

	//@RequestMapping(value = "clients", method = RequestMethod.GET)
	@GetMapping("/clients")
	public List<Client> findAll() {
		return clientService.findAll();
	}

	//@RequestMapping(value = "clients/{idClient}", method = RequestMethod.GET)
	@GetMapping("/clients/{idClient}")
	public Client findOne(@PathVariable("idClient") Long id) {
		return clientService.findOne(id);
	}

	//@RequestMapping(value = "clients", method = RequestMethod.POST)
	@PostMapping("/clients")
	public Client saveClient(@RequestBody Client client) {
		return clientService.save(client);
	}

	//@RequestMapping(value = "clients/{idClient}", method = RequestMethod.DELETE)
	@DeleteMapping("/clients/{idClient}")
	public void deleteClient(@PathVariable("idClient") Long id) {
		clientService.delete(id);
	}

	//@RequestMapping(value = "clients/{idClient}", method = RequestMethod.PUT)
	@PutMapping("/clients/{idClient}")
	public Client updateClient(@PathVariable("idClient") Long id, @RequestBody Client client) {
		Client currentClient = clientService.findOne(id);
		currentClient.setNom(client.getNom());
		currentClient.setPrenom(client.getPrenom());
		currentClient.setUsername(client.getUsername());
		currentClient.setPassword(client.getPassword());

		return clientService.save(currentClient);
	}

}

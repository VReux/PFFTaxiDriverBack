package com.inti.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Facture;
import com.inti.services.impl.FactureService;
import com.inti.services.interfaces.IFactureService;

@RestController
public class FactureController {
	@Autowired
	IFactureService factureService;

	@RequestMapping(value = "factures", method = RequestMethod.GET)
	public List<Facture> findAll() {
		return factureService.findAll();
	}

	@RequestMapping(value = "factures/{id}", method = RequestMethod.GET)
	public Facture findOne(@PathVariable("id") Long id) {
		return factureService.findOne(id);
	}

	@RequestMapping(value = "factures", method = RequestMethod.POST)
	public Facture saveUtilisateur(@RequestBody Facture facture) {
		return factureService.save(facture);
	}

	@RequestMapping(value = "factures/{id}", method = RequestMethod.DELETE)
	public void deleteUtilisateur(@PathVariable("id") Long id) {
		factureService.delete(id);
	}

	@RequestMapping(value = "factures/{id}", method = RequestMethod.PUT)
	public Facture updateFacture(@PathVariable("id") Long id, @RequestBody Facture facture) {
		Facture currentFacture = factureService.findOne(id);
		currentFacture.setTempsCourse(facture.getTempsCourse());
		currentFacture.setPrixReelHT(facture.getPrixReelHT());
		currentFacture.setPrixReelTTC(facture.getPrixReelTTC());
		currentFacture.setTva(facture.getTva());
		return factureService.save(currentFacture);
	}
}

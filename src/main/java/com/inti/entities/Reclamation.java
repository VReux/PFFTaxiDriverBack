package com.inti.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "RECLAMATIONS", schema = "taxi_driver_db")
public class Reclamation implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idReclamation;
	private String texte;

	@ManyToOne
	@JoinColumn(name = "id_client")
	
	private Client client;

	// constructeurs
	public Reclamation() {
	}

	public Reclamation(String texte) {
		this.texte = texte;
	}

	public Reclamation(String texte, Client client) {
		this.texte = texte;
		this.client = client;
	}

	// getters/setters
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Long getIdReclamation() {
		return idReclamation;
	}

	public void setIdReclamation(Long idReclamation) {
		this.idReclamation = idReclamation;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	@Override
	public String toString() {
		return "Reclamation [texte=" + texte + "]";
	}

}

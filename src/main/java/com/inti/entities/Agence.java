package com.inti.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "AGENCES", schema = "taxi_driver_db")
public class Agence implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAgence;

	private String nomAgence;

	@OneToMany(mappedBy = "agence", cascade = CascadeType.REMOVE)
	private List<Chauffeur> chauffeurs = new ArrayList<>();

	@OneToMany(mappedBy = "agence", cascade = CascadeType.REMOVE)
	private List<Taxi> taxis = new ArrayList<>();

	public Agence() {
	}

	public Agence(String nomAgence) {
		this.nomAgence = nomAgence;
	}

	public Agence(String nomAgence, List<Taxi> taxis) {
		this.nomAgence = nomAgence;
		this.taxis = taxis;
	}

	public Long getIdAgence() {
		return idAgence;
	}

	public void setIdAgence(Long idAgence) {
		this.idAgence = idAgence;
	}

	public String getNomAgence() {
		return nomAgence;
	}

	public void setNomAgence(String nomAgence) {
		this.nomAgence = nomAgence;
	}

	@Override
	public String toString() {
		return "Agence [idAgence=" + idAgence + ", nomAgence=" + nomAgence + "]";
	}

}

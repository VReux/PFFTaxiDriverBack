package com.inti.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("Chauffeur")
public class Chauffeur extends Utilisateur {

	private String numPermis;

	public String getNumPermis() {
		return numPermis;
	}

	public void setNumPermis(String numPermis) {
		this.numPermis = numPermis;
	}

	// Associations

	@OneToOne
	@JoinColumn(name = "id_taxi")
	private Taxi taxi;

	public Taxi getTaxi() {
		return taxi;
	}

	public void setTaxi(Taxi taxi) {
		this.taxi = taxi;
	}

	@ManyToOne
	@JoinColumn(name = "Agence")
	private Agence agence;

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	@OneToMany(mappedBy = "chauffeur", cascade = CascadeType.REMOVE)
	private List<Course> courses = new ArrayList<>();

	

	public Chauffeur() {
		super();
	}

	public Chauffeur(String numPermis) {
		super();
		this.numPermis = numPermis;
	}

	@Override
	public String toString() {
		return super.toString() + "Chauffeur [numPermis=" + numPermis + "]";
	}

}

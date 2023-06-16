package com.inti.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorValue("Chauffeur")
public class Chauffeur extends Utilisateur implements Serializable {

	private String numPermis;

	public String getNumPermis() {
		return numPermis;
	}

	public void setNumPermis(String numPermis) {
		this.numPermis = numPermis;
	}

	// Associations

	@OneToOne
	@JoinColumn(name = "Taxi")
	private Taxi taxi;

	@ManyToOne
	@JoinColumn(name = "Agence")
	private Agence agence;

	@OneToMany(mappedBy = "chauffeur", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<Course> courses = new ArrayList<>();

	// constructeurs
	public Chauffeur() {
		super();
	}

	public Chauffeur(String numPermis) {
		super();
		this.numPermis = numPermis;
	}

	public Chauffeur(String numPermis, Taxi taxi, Agence agence) {
		super();
		this.numPermis = numPermis;
		this.taxi = taxi;
		this.agence = agence;
	}

	public Chauffeur(String numPermis, Taxi taxi) {
		super();
		this.numPermis = numPermis;
		this.taxi = taxi;
	}

	// getters/setters
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Taxi getTaxi() {
		return taxi;
	}

	public void setTaxi(Taxi taxi) {
		this.taxi = taxi;
	}

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	@Override
	public String toString() {
		return super.toString() + "Chauffeur [numPermis=" + numPermis + "]";
	}

}

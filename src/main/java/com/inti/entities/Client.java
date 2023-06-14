package com.inti.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorValue("Client")
public class Client extends Utilisateur implements Serializable {

	private String email;

	
	// Associations
	@OneToMany(mappedBy = "client", cascade = CascadeType.REMOVE)
	private List<Reclamation> reclamations = new ArrayList<>();

	@OneToMany(mappedBy = "client", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<Reservation> reservations = new ArrayList<>();

	// constructeurs
	public Client() {
		super();
	}

	public Client(String email) {
		super();
		this.email = email;
	}

	// getters/setters

	public List<Reclamation> getReclamations() {
		return reclamations;
	}

	public void setReclamations(List<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	// toString
	@Override
	public String toString() {
		return super.toString() + "Client [email=" + email + "]";
	}

}

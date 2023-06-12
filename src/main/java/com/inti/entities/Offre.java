package com.inti.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "OFFRES", schema = "taxi_driver_db")
public class Offre implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOffre;
	private String codePromo;

	@ManyToOne
	@JoinColumn(name = "id_Utilisateur")
	private Utilisateur utilisateur;

	@ManyToOne
	@JoinColumn(name = "id_Reservation")
	private Reservation reservation;

	
	
	//constructeurs
	public Offre() {
	}

	public Offre(String codePromo) {
		this.codePromo = codePromo;
	}
	
	
	public Offre(String codePromo, Utilisateur utilisateur, Reservation reservation) {
		this.codePromo = codePromo;
		this.utilisateur = utilisateur;
		this.reservation = reservation;
	}

	//getters/setters
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	

	public Long getIdOffre() {
		return idOffre;
	}

	public void setIdOffre(Long idOffre) {
		this.idOffre = idOffre;
	}

	public String getCodePromo() {
		return codePromo;
	}

	public void setCodePromo(String codePromo) {
		this.codePromo = codePromo;
	}

	@Override
	public String toString() {
		return "Offre [idOffre=" + idOffre + ", codePromo=" + codePromo + "]";
	}

}

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
@Table(name = "OFFRES", schema = "taxi_driver_db")
public class Offre implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOffre;
	private String codePromo;
	private String descriptionOffre;
	private float remiseOffre;
	
	public float getRemiseOffre() {
		return remiseOffre;
	}

	public void setRemiseOffre(float remiseOffre) {
		this.remiseOffre = remiseOffre;
	}

	public String getDescriptionOffre() {
		return descriptionOffre;
	}

	public void setDescriptionOffre(String descriptionOffre) {
		this.descriptionOffre = descriptionOffre;
	}

	@ManyToOne
	@JoinColumn(name = "id_Utilisateur")
	@JsonIgnore
	private Utilisateur utilisateur;

	@ManyToOne
	@JoinColumn(name = "id_Reservation")
	@JsonIgnore
	private Reservation reservation;

	// constructeurs
	public Offre() {
	}

	public Offre(String codePromo) {
		this.codePromo = codePromo;
	}

	public Offre(String codePromo, String descriptionOffre, Utilisateur utilisateur, Reservation reservation,float remiseOffre) {
		this.codePromo = codePromo;
		this.utilisateur = utilisateur;
		this.reservation = reservation;
		this.descriptionOffre = descriptionOffre;
		this.remiseOffre = remiseOffre;
	}

	// getters/setters
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

package com.inti.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "RESERVATIONS", schema = "taxi_driver_db")
public class Reservation implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idReservation;
	@Temporal(TemporalType.DATE)
	private Date heureDepart;
	private float tauxHoraire;
	private boolean validation;
	private String depart;
	private String arrivee;
	private float distancekm;

	@OneToMany(mappedBy = "reservation")
	private List<Offre> offres = new ArrayList<>();

	@OneToOne
	@JoinColumn(name = "id_course")
	@JsonIgnore
	private Course course;

	@ManyToOne
	@JoinColumn(name = "id_Client")
	private Client client;

	// constructeur
	public Reservation() {
	}

	public Reservation(Date heureDepart, float tauxHoraire, boolean validation) {
		this.heureDepart = heureDepart;
		this.tauxHoraire = tauxHoraire;
		this.validation = validation;
	}

	public Reservation(Date heureDepart, float tauxHoraire, boolean validation, String depart, String arrivee,
			List<Offre> offres, Course course, Client client) {
		super();
		this.heureDepart = heureDepart;
		this.tauxHoraire = tauxHoraire;
		this.validation = validation;
		this.depart = depart;
		this.arrivee = arrivee;
		this.offres = offres;
		this.course = course;
		this.client = client;
	}

	// getters/setters
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<Offre> getOffres() {
		return offres;
	}

	public void setOffres(List<Offre> offres) {
		this.offres = offres;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Long getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(Long idReservation) {
		this.idReservation = idReservation;
	}

	public Date getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(Date heureDepart) {
		this.heureDepart = heureDepart;
	}

	public float getTauxHoraire() {
		return tauxHoraire;
	}

	public void setTauxHoraire(float tauxHoraire) {
		this.tauxHoraire = tauxHoraire;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getArrivee() {
		return arrivee;
	}

	public void setArrivee(String arrivee) {
		this.arrivee = arrivee;
	}

	public boolean isValidation() {
		return validation;
	}

	public boolean getValidation() {
		return validation;
	}

	public void setValidation(boolean validation) {
		this.validation = validation;
	}

	public float getDistancekm() {
		return distancekm;
	}

	public void setDistancekm(float distancekm) {
		this.distancekm = distancekm;
	}

	@Override
	public String toString() {
		return "Reservation [idReservation=" + idReservation + ", heureDepart=" + heureDepart + ", tauxHoraire="
				+ tauxHoraire + ", validation=" + validation + "]";
	}

}

package com.inti.entities;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Column;

import com.inti.model.Adresse;

@Embeddable
@Entity
@Table(name = "COURSES", schema = "taxi_driver_db")
public class Course implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCourse;
	private String avisCourse;
	private float noteCourse;
	private float noteChauffeur;
	private float tempsCourse;
	private float prixReel;
	/*
	 * @Embedded private Adresse adresseDepart;
	 * 
	 * @Embedded private Adresse adresseArrivee;
	 */

	@Embedded
	@AttributeOverrides({ 
			@AttributeOverride(name = "rue", column = @Column(name = "adresseDepart_rue")),
			@AttributeOverride(name = "codePostal", column = @Column(name = "adresseDepart_codePostal")),
			@AttributeOverride(name = "ville", column = @Column(name = "adresseDepart_ville")) })
	private Adresse adresseDepart;

	@Embedded
	@AttributeOverrides({ 
		@AttributeOverride(name = "rue", column = @Column(name = "adresseArrivee_rue")),
		@AttributeOverride(name = "codePostal", column = @Column(name = "adresseArrivee_codePostal")),
		@AttributeOverride(name = "ville", column = @Column(name = "adresseArrivee_ville")) })
	private Adresse adresseArrivee;

	// @OneToOne(mappedBy="courseFK")
	// private Facture facture;

	// @OneToOne
	// @JoinColumn(name = "id_reservation")
	// private Reservation reservationFK;

	// @ManyToOne
	// @JoinColumn(name="id_chauffeur")
	// private Chauffeur chauffeur;

	public Course() {

	}

	public Course(float tempsCourse, float prixReel, Adresse adresseDepart, Adresse adresseArrivee) {
		this.tempsCourse = tempsCourse;
		this.prixReel = prixReel;
		this.adresseDepart = adresseDepart;
		this.adresseArrivee = adresseArrivee;
	}

	public Course(String avisCourse, float noteCourse, float noteChauffeur, float tempsCourse, float prixReel,
			Adresse adresseDepart, Adresse adresseArrivee) {
		super();
		this.avisCourse = avisCourse;
		this.noteCourse = noteCourse;
		this.noteChauffeur = noteChauffeur;
		this.tempsCourse = tempsCourse;
		this.prixReel = prixReel;
		this.adresseDepart = adresseDepart;
		this.adresseArrivee = adresseArrivee;
	}

	public Long getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(Long idCourse) {
		this.idCourse = idCourse;
	}

	public String getAvisCourse() {
		return avisCourse;
	}

	public void setAvisCourse(String avisCourse) {
		this.avisCourse = avisCourse;
	}

	public float getNoteCourse() {
		return noteCourse;
	}

	public void setNoteCourse(float noteCourse) {
		this.noteCourse = noteCourse;
	}

	public float getNoteChauffeur() {
		return noteChauffeur;
	}

	public void setNoteChauffeur(float noteChauffeur) {
		this.noteChauffeur = noteChauffeur;
	}

	public float getTempsCourse() {
		return tempsCourse;
	}

	public void setTempsCourse(float tempsCourse) {
		this.tempsCourse = tempsCourse;
	}

	public float getPrixReel() {
		return prixReel;
	}

	public void setPrixReel(float prixReel) {
		this.prixReel = prixReel;
	}

	public Adresse getAdresseDepart() {
		return adresseDepart;
	}

	public void setAdresseDepart(Adresse adresseDepart) {
		this.adresseDepart = adresseDepart;
	}

	public Adresse getAdresseArrivee() {
		return adresseArrivee;
	}

	public void setAdresseArrivee(Adresse adresseArrivee) {
		this.adresseArrivee = adresseArrivee;
	}
	

	@Override
	public String toString() {
		return "Course [avisCourse=" + avisCourse + ", noteCourse=" + noteCourse + ", noteChauffeur=" + noteChauffeur
				+ ", tempsCourse=" + tempsCourse + ", prixReel=" + prixReel + ", adresseDepart=" + adresseDepart
				+ ", adresseArrivee=" + adresseArrivee + "]";
	}

}
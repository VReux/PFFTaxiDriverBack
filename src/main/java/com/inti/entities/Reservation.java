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
import javax.persistence.Table;
import javax.persistence.Column;

import com.inti.model.Adresse;

@Entity
@Table(name = "RESERVATIONS", schema = "taxi_driver_db")
public class Reservation implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idReservation;
	private Date heureDepart;
	private float tauxHoraire;
	private boolean validation;
	
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
	
	/*@OneToMany(mappedBy = "reservation")
	private List<Offre> offres = new ArrayList<>();*/
	/*@OneToOne 
	@JoinColumn(name = "id_course")
	private Course courseForeignKey;*/
	public Reservation() {
	}
	
	public Reservation(Date heureDepart, float tauxHoraire, boolean validation) {
		this.heureDepart = heureDepart;
		this.tauxHoraire = tauxHoraire;
		this.validation = validation;
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

	public boolean isValidation() {
		return validation;
	}
	
	public boolean getValidation() {
        return validation;
	}

	public void setValidation(boolean validation) {
		this.validation = validation;
	}

	@Override
	public String toString() {
		return "Reservation [idReservation=" + idReservation + ", heureDepart=" + heureDepart + ", tauxHoraire="
				+ tauxHoraire + ", validation=" + validation + "]";
	}
	
	
	

	
	
}
package com.inti.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TAXIS", schema = "taxi_driver_db")
public class Taxi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTaxi;
	private String immatriculation;
	private String marque;
	private String modele;
	@ManyToOne
	@JoinColumn(name="id_agence")
	private Agence agence;
	// @OneToOne (mappedBy="taxi")
	// private Chauffeur chauffeur;

	public Taxi() {
	}

	public Taxi(Long idTaxi, String immatriculation, String marque, String modele) {
		super();
		this.idTaxi = idTaxi;
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.modele = modele;
	}

	public Long getIdTaxi() {
		return idTaxi;
	}

	public void setIdTaxi(Long idTaxi) {
		this.idTaxi = idTaxi;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	@Override
	public String toString() {
		return "Taxi [idTaxi=" + idTaxi + ", immatriculation=" + immatriculation + ", marque=" + marque + ", modele="
				+ modele + "]";
	}

}

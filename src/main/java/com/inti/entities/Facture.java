package com.inti.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "FACTURES", schema = "taxi_driver_db")
public class Facture implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFacture;
	private float tempsCourse;
	private float prixReelHT;
	private float prixReelTTC;
	private float tva;
	@Temporal(TemporalType.DATE)
	private Date date;
	/*
	 * @OneToOne
	 * 
	 * @JoinColumn(name = "id_course") private Course courseForeignKey;
	 */

	public Facture() {

	}

	public Facture(float tempsCourse, float prixReelHT, float prixReelTTC, float tva, Date date) {
		this.tempsCourse = tempsCourse;
		this.prixReelHT = prixReelHT;
		this.prixReelTTC = prixReelTTC;
		this.tva = tva;
		this.date = date;
	}

	public Long getIdFacture() {
		return idFacture;
	}

	public void setIdFacture(Long idFacture) {
		this.idFacture = idFacture;
	}

	public float getTempsCourse() {
		return tempsCourse;
	}

	public void setTempsCourse(float tempsCourse) {
		this.tempsCourse = tempsCourse;
	}

	public float getPrixReelHT() {
		return prixReelHT;
	}

	public void setPrixReelHT(float prixReelHT) {
		this.prixReelHT = prixReelHT;
	}

	public float getPrixReelTTC() {
		return prixReelTTC;
	}

	public void setPrixReelTTC(float prixReelTTC) {
		this.prixReelTTC = prixReelTTC;
	}

	public float getTva() {
		return tva;
	}

	public void setTva(float tva) {
		this.tva = tva;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Facture [idFacture=" + idFacture + ", tempsCourse=" + tempsCourse + ", prixReelHT=" + prixReelHT
				+ ", prixReelTTC=" + prixReelTTC + ", tva=" + tva + ", date=" + date + "]";
	}

}

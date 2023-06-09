package com.inti.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RECLAMATIONS", schema = "taxi_driver_db")
public class Reclamation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idReclamation;
	private String texte;

	// @ManyToOne
	// @JoinColumn(name="id_client")
	// private Client client;

	public Reclamation() {

	}

	public Reclamation(String texte) {
		this.texte = texte;
	}

	public Long getIdReclamation() {
		return idReclamation;
	}

	public void setIdReclamation(Long idReclamation) {
		this.idReclamation = idReclamation;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	@Override
	public String toString() {
		return "Reclamation [texte=" + texte + "]";
	}

}

package com.inti.entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="UTILISATEURS", schema="taxi_driver_db")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", discriminatorType=DiscriminatorType.STRING)
public class Utilisateur {
	// attributs
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long idUtilisateur;
		
		
		private String nom;
		private String prenom;
		private String username;
		private String password;

		//relations
	/*	@OneToMany(mappedBy="utilisateur")
		private List<Offre> offres=new ArrayList<>();

		public List<Offre> getOffres() {
			return offres;
		}

		public void setOffres(List<Offre> offres) {
			this.offres = offres;
		}*/
		
		
		
		public Long getIdUtilisateur() {
			return idUtilisateur;
		}

		public void setIdUtilisateur(Long idUtilisateur) {
			this.idUtilisateur = idUtilisateur;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Utilisateur() {
		}
		
		public Utilisateur(Long idUtilisateur, String nom, String prenom, String username, String password) {
			this.idUtilisateur = idUtilisateur;
			this.nom = nom;
			this.prenom = prenom;
			this.username = username;
			this.password = password;
		}

		@Override
		public String toString() {
			return "Utilisateur [idUtilisateur=" + idUtilisateur + ", nom=" + nom + ", prenom=" + prenom + ", username="
					+ username + ", password=" + password + "]";
		}

}

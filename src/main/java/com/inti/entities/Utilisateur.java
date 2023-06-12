package com.inti.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "UTILISATEURS", schema = "taxi_driver_db")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class Utilisateur implements Serializable {
	// attributs

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUtilisateur;

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	private String nom;
	
	private String prenom;
	
	@Column(unique=true)
	private String username;
	
	private String password;

	// relations
	@OneToMany(mappedBy = "utilisateur", cascade = CascadeType.REMOVE)
	private List<Offre> offres = new ArrayList<>();



	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "PROFILS", joinColumns = @JoinColumn(name = "idUtilisateur", referencedColumnName = "idUtilisateur"), inverseJoinColumns = @JoinColumn(name = "idRole", referencedColumnName = "idRole"))
	private Set<Role> roles = new HashSet<>();

	
	//constructeurs
	
	public Utilisateur() {
	}

	public Utilisateur(String nom, String prenom, String username, String password) {
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.password = password;
	}
	
	
	public Utilisateur(String nom, String prenom, String username, String password,
			Set<Role> roles) {
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	//getters/setters
	
	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public List<Offre> getOffres() {
		return offres;
	}

	public void setOffres(List<Offre> offres) {
		this.offres = offres;
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



	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", nom=" + nom + ", prenom=" + prenom + ", username="
				+ username + ", password=" + password + "]";
	}

}

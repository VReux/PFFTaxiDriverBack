package com.inti.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("Client")
public class Client extends Utilisateur{

		private String email;

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		//Associations
		
		@OneToMany(mappedBy="client")
		private List<Reclamation> reclamations= new ArrayList<>();
		
		
		public List<Reclamation> getReclamations() {
			return reclamations;
		}

		public void setReclamations(List<Reclamation> reclamations) {
			this.reclamations = reclamations;
		}
	
		
		@OneToMany(mappedBy="client")
		private List<Reservation> reservations= new ArrayList<>();
		
		
		public List<Reservation> getReservations() {
			return reservations;
		}

		public void setReservations(List<Reservation> reservations) {
			this.reservations = reservations;
		}
		
		

		public Client() {
			super();
		}

		
		
		public Client(String email) {
			super();
			this.email = email;
		}

		@Override
		public String toString() {
			return super.toString() + "Client [email=" + email + "]";
		}
		
		
}

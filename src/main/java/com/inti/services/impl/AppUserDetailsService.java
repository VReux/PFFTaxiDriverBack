package com.inti.services.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.inti.entities.Role;
import com.inti.entities.Utilisateur;
import com.inti.model.UtilisateurDetail;
import com.inti.services.interfaces.IUtilisateurService;

@Service
public class AppUserDetailsService implements UserDetailsService {
	
	@Autowired
	IUtilisateurService utilisateurService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Utilisateur utilisateur=utilisateurService.findByUsername(username);
		/*
		 * utilisateur => username = luffy, roles : {1:admin, 3:comptable}
		 * profil : id_user : 1, id_role : 1 => admin
		 * profil : id_user : 1, id_role : 3 => comptable
		 */
		// Récupération des profils
		// Les roles des utilisateurs
		Set<Role> roles = utilisateur.getRoles();
		// Les profils
		// GrantedAuthority = profil
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		for(Role role:roles) {
			authorities.add(new SimpleGrantedAuthority(role.getLibelle()));
		}
		// Fin de récupération des profils
		UtilisateurDetail utilisateurDetail = new UtilisateurDetail();
		utilisateurDetail.setUtilisateur(utilisateur); // utilisateurs
		utilisateurDetail.setAuthorities(authorities); // profils
		return utilisateurDetail;	// objet qui stocke l'utilisateur et les profils
	}
	
	

}
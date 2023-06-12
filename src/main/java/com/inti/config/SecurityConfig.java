package com.inti.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.inti.services.impl.AppUserDetailsService;

@Configuration		// Pour créer un Bean dans le context Spring avec le nom securityConfig
@EnableWebSecurity		// Activation de la sécurité Web
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private AppUserDetailsService appUserDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(appUserDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}
	public void configure(HttpSecurity http) throws Exception{
		http 	// la sécurité des requetes http
			.authorizeRequests()
			.anyRequest().authenticated()	// vérifier les requetes envoyées par les utilisateurs : 
											// http://localhost:9090/utilisateurs
											// http://localhost:9090/login
			.and()
			.formLogin()		// formulaire login fournit par le projet Spring Security
				.permitAll()
			.and()
			.logout()
				.logoutUrl("/logout")
				.permitAll()
			.and()
			.httpBasic()
			.and()
			.csrf().disable();	// méthode d'attaque informatique (cybersécurité)
			
			
	}

}

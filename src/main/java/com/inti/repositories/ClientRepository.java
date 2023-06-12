package com.inti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}

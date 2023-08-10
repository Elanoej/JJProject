package com.eletronica.JJProject.repositories;

import com.eletronica.JJProject.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}

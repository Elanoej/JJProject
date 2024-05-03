package com.eletronica.JJProject.repositories;

import com.eletronica.JJProject.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    @Query("SELECT obj FROM Client obj WHERE UPPER(obj.name) LIKE CONCAT('%', UPPER(:name), '%')")
    List<Client> findByName(String name);
}

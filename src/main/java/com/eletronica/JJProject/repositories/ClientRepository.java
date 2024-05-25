package com.eletronica.JJProject.repositories;

import com.eletronica.JJProject.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    @Query("SELECT obj FROM Client obj WHERE UPPER(obj.name) LIKE CONCAT('%', UPPER(:name), '%')")
    List<Client> findByName(String name);

    @Query("SELECT c FROM Client c WHERE"
        + " CAST(c.id AS string) = :param"
        + " or UPPER(c.name) LIKE CONCAT('%', UPPER(:param), '%')"
        + " or UPPER(c.cellphone) LIKE CONCAT('%', UPPER(:param), '%')"
        + " or UPPER(c.address.logradouro) LIKE CONCAT('%', UPPER(:param), '%')"
        + " or UPPER(c.address.complemento) LIKE CONCAT('%', UPPER(:param), '%')"
        + " or UPPER(c.address.bairro) LIKE CONCAT('%', UPPER(:param), '%')"
    )
    List<Client> findByAnyParams(String param);
}

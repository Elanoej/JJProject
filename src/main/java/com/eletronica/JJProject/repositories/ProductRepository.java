package com.eletronica.JJProject.repositories;

import com.eletronica.JJProject.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT obj FROM Product obj WHERE UPPER(obj.name) LIKE CONCAT('%', UPPER(:name),'%')")
    List<Product> findByName(String name);
}

package com.eletronica.JJProject.repositories;

import com.eletronica.JJProject.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

package com.eletronica.JJProject.services;

import com.eletronica.JJProject.exceptions.ResourceNotFoundException;
import com.eletronica.JJProject.model.Product;
import com.eletronica.JJProject.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ProductService {

    private Logger logger = Logger.getLogger(ProductService.class.getName());

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll(){
        logger.info("Finding all products");
        return repository.findAll();
    }

    public Product findById(Long id){
        logger.info("Finding one product");
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
    }

    public Product create(Product product){
        logger.info("Creating one person");
        return repository.save(product);
    }

    public Product update(Product product){
        logger.info("Updating one product");

        return null;
    }

    public void delete(Long id){
        logger.info("Deleting one product");
    }



}

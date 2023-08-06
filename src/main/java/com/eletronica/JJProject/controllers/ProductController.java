package com.eletronica.JJProject.controllers;

import com.eletronica.JJProject.model.Product;
import com.eletronica.JJProject.services.ProductService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> findAll(){
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product findById(@PathVariable(value = "id") Long id){
        return service.findById(id);
    }


}

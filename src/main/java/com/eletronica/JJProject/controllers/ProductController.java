package com.eletronica.JJProject.controllers;

import com.eletronica.JJProject.data.dto.v1.ProductDTO;
import com.eletronica.JJProject.services.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Product", description = "Product API")
@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductDTO>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDTO> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO product){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(product));
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDTO> update(@RequestBody ProductDTO product){
        return  ResponseEntity.status(HttpStatus.OK).body(service.update(product));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}

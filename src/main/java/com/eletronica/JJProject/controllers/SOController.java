package com.eletronica.JJProject.controllers;

import com.eletronica.JJProject.data.dto.v1.ServiceOrderDTO;
import com.eletronica.JJProject.services.SOService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Service Order", description = "Service Order API")
@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequestMapping("/api/service-order")
public class SOController {

    @Autowired
    private SOService service;

    @GetMapping
    public ResponseEntity<List<ServiceOrderDTO>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ServiceOrderDTO> findById(@PathVariable(value = "id") Integer id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ServiceOrderDTO> create(@RequestBody ServiceOrderDTO serviceOrderDTO){
        return new ResponseEntity<>(service.create(serviceOrderDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ServiceOrderDTO> update(@RequestBody ServiceOrderDTO serviceOrderDTO){
        return new ResponseEntity<>(service.update(serviceOrderDTO), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Integer id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

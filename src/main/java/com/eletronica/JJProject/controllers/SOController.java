package com.eletronica.JJProject.controllers;

import com.eletronica.JJProject.data.vo.v1.ServiceOrderVO;
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
    public ResponseEntity<List<ServiceOrderVO>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ServiceOrderVO> findById(@PathVariable(value = "id") Integer id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ServiceOrderVO> create(@RequestBody ServiceOrderVO serviceOrderVO){
        return new ResponseEntity<>(service.create(serviceOrderVO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ServiceOrderVO> update(@RequestBody ServiceOrderVO serviceOrderVO){
        return new ResponseEntity<>(service.update(serviceOrderVO), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Integer id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

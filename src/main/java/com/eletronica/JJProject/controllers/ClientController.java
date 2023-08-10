package com.eletronica.JJProject.controllers;

import com.eletronica.JJProject.data.vo.v1.ClientVO;
import com.eletronica.JJProject.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClientVO>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientVO> findById(@PathVariable(value = "id") Integer id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClientVO> create(@RequestBody ClientVO clientVO){
        return new ResponseEntity<>(service.create(clientVO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ClientVO> update(@RequestBody ClientVO clientVO){
        return new ResponseEntity<>(service.update(clientVO), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

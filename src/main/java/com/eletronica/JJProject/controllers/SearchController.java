package com.eletronica.JJProject.controllers;

import com.eletronica.JJProject.data.dto.v1.SearchDTO;
import com.eletronica.JJProject.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequestMapping("/api/search")
public class SearchController {

    @Autowired
    private SearchService service;

    @GetMapping(value = "/{value}")
    public ResponseEntity<List<SearchDTO>> findAll(@PathVariable String value){
        return new ResponseEntity<>(service.findAll(value), HttpStatus.OK);
    }
}

package com.eletronica.JJProject.controllers;

import com.eletronica.JJProject.data.vo.v1.ClientVO;
import com.eletronica.JJProject.services.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Client", description = "Client API")
@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientService service;

    @Operation(summary = "Find all Clients")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the books",
            content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array =
            @ArraySchema(schema = @Schema(implementation = ClientVO.class)))}),
            @ApiResponse(responseCode = "400", description = "No books found", content = @Content),
            @ApiResponse(responseCode = "404", description = "Book not found", content = @Content)
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClientVO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientVO> findById(@PathVariable(value = "id") Integer id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
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

package com.eletronica.JJProject.controllers;

import com.eletronica.JJProject.data.dto.v1.ClientDTO;
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
            @ArraySchema(schema = @Schema(implementation = ClientDTO.class)))}),
            @ApiResponse(responseCode = "400", description = "No clients found", content = @Content),
            @ApiResponse(responseCode = "404", description = "Clients not found", content = @Content)
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClientDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @Operation(summary = "Find a client by given id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Found the client",
            content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ClientDTO.class))}),
            @ApiResponse(responseCode = "404", description = "No client found for given id", content = @Content)
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientDTO> findById(@PathVariable(value = "id") Integer id){
        return ResponseEntity.ok(service.findById(id));
    }

    @Operation(summary = "Creates a client")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Client created",
            content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema =
            @Schema(implementation = ClientDTO.class))})
    })
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientDTO> create(@RequestBody ClientDTO clientDTO){
        return new ResponseEntity<>(service.create(clientDTO), HttpStatus.CREATED);
    }

    @Operation(summary = "Updates a client")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Client updated", content =
            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ClientDTO.class))),
            @ApiResponse(responseCode = "404", description = "No client found for given id", content = @Content)
    })
    @PutMapping
    public ResponseEntity<ClientDTO> update(@RequestBody ClientDTO clientDTO){
        return new ResponseEntity<>(service.update(clientDTO), HttpStatus.OK);
    }

    @Operation(summary = "Deletes a client")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Client deleted", content = @Content),
            @ApiResponse(responseCode = "404", description = "No client found for given id", content = @Content)
    })
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/search/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClientDTO>> findByName(@PathVariable String name){
        return ResponseEntity.ok(service.findByName(name));
    }
}

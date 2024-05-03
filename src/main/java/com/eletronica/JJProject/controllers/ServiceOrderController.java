package com.eletronica.JJProject.controllers;

import com.eletronica.JJProject.data.dto.v1.ServiceOrderDTO;
import com.eletronica.JJProject.services.ServiceOrderService;
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

@Tag(name = "Service Order", description = "Service Order API")
@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequestMapping("/api/service-order")
public class ServiceOrderController {

    @Autowired
    private ServiceOrderService service;

    @Operation(summary = "Find all Service Orders")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Services Orders found",
            content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array =
            @ArraySchema(schema = @Schema(implementation = ServiceOrderDTO.class)))}),
            @ApiResponse(responseCode = "400", description = "No Service Order found", content = @Content),
            @ApiResponse(responseCode = "404", description = "Service Order not found", content = @Content)
    })
    @GetMapping
    public ResponseEntity<List<ServiceOrderDTO>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Find Service Order by id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Service Order found",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ServiceOrderDTO.class))),
            @ApiResponse(responseCode = "404", description = "No Service Order found for giver id", content = @Content)
    })
    @GetMapping(value = "/{id}")
    public ResponseEntity<ServiceOrderDTO> findById(@PathVariable(value = "id") Integer id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @Operation(summary = "Creates a Service Order")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Service Order created", content =
            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ServiceOrderDTO.class))),
            @ApiResponse(responseCode = "404", description = "Client not found", content = @Content)
    })
    @PostMapping
    public ResponseEntity<ServiceOrderDTO> create(@RequestBody ServiceOrderDTO serviceOrderDTO){
        return new ResponseEntity<>(service.create(serviceOrderDTO), HttpStatus.CREATED);
    }

    @Operation(summary = "Updates a ServiceOrder")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Service Order updated",content =
            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ServiceOrderDTO.class))),
            @ApiResponse(responseCode = "404", description = "Service Order not found", content = @Content)
    })
    @PutMapping
    public ResponseEntity<ServiceOrderDTO> update(@RequestBody ServiceOrderDTO serviceOrderDTO){
        return new ResponseEntity<>(service.update(serviceOrderDTO), HttpStatus.OK);
    }

    @Operation(summary = "Deletes a Service Order")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Service Order deleted", content = @Content),
            @ApiResponse(responseCode = "404", description = "Service Order not found for given id", content = @Content)
    })
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Integer id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search/{name}")
    public List<ServiceOrderDTO> findbyName(@PathVariable String name){
        return service.findByClientName(name);
    }
}

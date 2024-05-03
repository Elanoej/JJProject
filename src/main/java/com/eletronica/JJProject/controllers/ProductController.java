package com.eletronica.JJProject.controllers;

import com.eletronica.JJProject.data.dto.v1.ProductDTO;
import com.eletronica.JJProject.services.ProductService;
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

@Tag(name = "Product", description = "Product API")
@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @Operation(summary = "Find all Products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Products found",
            content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array =
            @ArraySchema(schema = @Schema(implementation = ProductDTO.class)))}),
            @ApiResponse(responseCode = "400", description = "No Products found", content = @Content),
            @ApiResponse(responseCode = "404", description = "Products not found", content = @Content)
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductDTO>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @Operation(summary = "Finds a product by given id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Found the product",
            content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ProductDTO.class))}),
            @ApiResponse(responseCode = "404", description = "No product found for given id", content = @Content)
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDTO> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @Operation(summary = "Creates a product")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Product created",
            content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema =
            @Schema(implementation = ProductDTO.class))})
    })
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO product){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(product));
    }

    @Operation(summary = "Updates a product")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Product updated", content =
            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ProductDTO.class))),
            @ApiResponse(responseCode = "404", description = "No product found for given id", content = @Content)
    })
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDTO> update(@RequestBody ProductDTO product){
        return  ResponseEntity.status(HttpStatus.OK).body(service.update(product));
    }

    @Operation(summary = "Deletes a product")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Product deleted", content = @Content),
            @ApiResponse(responseCode = "404", description = "No product found for given id", content = @Content)
    })
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<ProductDTO>> findByName(@PathVariable String name){
        return ResponseEntity.ok(service.findByName(name));
    }

}

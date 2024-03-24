package com.eletronica.JJProject.services;

import com.eletronica.JJProject.controllers.ProductController;
import com.eletronica.JJProject.data.dto.v1.ProductDTO;
import com.eletronica.JJProject.exceptions.ResourceNotFoundException;
import com.eletronica.JJProject.mapper.ProductMapper;
import com.eletronica.JJProject.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ProductService {

    private Logger logger = Logger.getLogger(ProductService.class.getName());

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ProductMapper mapper;

    public List<ProductDTO> findAll(){
        logger.info("Finding all products");

        var dtos = mapper.convertListToVO(repository.findAll(Sort.by("id")));
        return dtos.stream().map(this::addHateoas).collect(Collectors.toList());
    }

    public ProductDTO findById(Long id){
        logger.info("Finding one product");

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        var dto = mapper.convertEntityToDTO(entity);
        return addHateoas(dto);
    }

    public ProductDTO create(ProductDTO product){
        logger.info("Creating one product");

        var entity = mapper.convertDTOToEntity(product);
        var dto = mapper.convertEntityToDTO(repository.save(entity));
        return addHateoas(dto);
    }

    public ProductDTO update(ProductDTO product){
        logger.info("Updating one product");

        var entity = repository.findById(product.getKey()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setName(product.getName());
        entity.setPrice(product.getPrice());
        entity.setType(product.getType());
        entity.setQuantity(product.getQuantity());

        var dto = mapper.convertEntityToDTO(repository.save(entity));
        return addHateoas(dto);
    }

    public void delete(Long id){
        logger.info("Deleting one product");

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }

    private ProductDTO addHateoas(ProductDTO dto){
        dto.add(linkTo(methodOn(ProductController.class).findById(dto.getKey())).withSelfRel());
        return dto;
    }

}

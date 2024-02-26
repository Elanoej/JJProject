package com.eletronica.JJProject.services;

import com.eletronica.JJProject.controllers.ProductController;
import com.eletronica.JJProject.data.vo.v1.ProductVO;
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

    public List<ProductVO> findAll(){
        logger.info("Finding all products");

        var vos = mapper.convertListToVO(repository.findAll(Sort.by("id")));
        vos = vos.stream().map(productVO ->
                productVO.add(linkTo(methodOn(ProductController.class).findById(productVO.getKey())).withSelfRel()))
                .collect(Collectors.toList());
        return vos;
    }

    public ProductVO findById(Long id){
        logger.info("Finding one product");

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        var vo = mapper.convertEntityToVO(entity).add(linkTo(methodOn(ProductController.class).findById(id)).withSelfRel());
        return vo;
    }

    public ProductVO create(ProductVO product){
        logger.info("Creating one product");

        var entity = mapper.convertVoToEntity(product);
        var vo = mapper.convertEntityToVO(repository.save(entity));
        vo.add(linkTo(methodOn(ProductController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public ProductVO update(ProductVO product){
        logger.info("Updating one product");

        var entity = repository.findById(product.getKey()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setName(product.getName());
        entity.setPrice(product.getPrice());
        entity.setType(product.getType());
        entity.setQuantity(product.getQuantity());

        var vo = mapper.convertEntityToVO(repository.save(entity));
        vo.add(linkTo(methodOn(ProductController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public void delete(Long id){
        logger.info("Deleting one product");

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }

}

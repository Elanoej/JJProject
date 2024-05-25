package com.eletronica.JJProject.services;

import com.eletronica.JJProject.controllers.ClientController;
import com.eletronica.JJProject.controllers.ServiceOrderController;
import com.eletronica.JJProject.data.dto.v1.ServiceOrderDTO;
import com.eletronica.JJProject.exceptions.ResourceNotFoundException;
import com.eletronica.JJProject.mapper.ServiceOrderMapper;
import com.eletronica.JJProject.model.ServiceOrder;
import com.eletronica.JJProject.repositories.ServiceOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ServiceOrderService {

    private Logger logger = Logger.getLogger(ProductService.class.getName());

    @Autowired
    private ServiceOrderRepository repository;

    @Autowired
    private ClientService clientService;

    @Autowired
    private ServiceOrderMapper mapper;

    public List<ServiceOrderDTO> findAll(){
        logger.info("Finding all services-orders");
        var dtos = mapper.convertListToDTO(repository.findAll(Sort.by("id")));
        return dtos.stream().map(this::addHateoas).collect(Collectors.toList());
    }

    public ServiceOrderDTO findById(Integer id){
        logger.info("Finding one ServiceOrder");

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        var dto = mapper.convertEntityToDTO(entity);

        return addHateoas(dto);
    }

    public ServiceOrderDTO create(ServiceOrderDTO serviceOrderDTO){
        logger.info("Creating one ServiceOrder");
        var client = clientService.findById(serviceOrderDTO.getClient().getKey());
        serviceOrderDTO.setClient(client);
        var dto = mapper.convertEntityToDTO(repository.save(mapper.convertDTOToEntity(serviceOrderDTO)));

        return addHateoas(dto);
    }

    public ServiceOrderDTO update(ServiceOrderDTO serviceOrderDTO){
        logger.info("Updating one ServiceOrder");

        var entity = repository.findById(serviceOrderDTO.getKey()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        var serviceOrder = mapper.convertDTOToEntity(serviceOrderDTO);
        entity.setDate(serviceOrder.getDate());
        entity.setClient(serviceOrder.getClient());
        entity.setProductDetails(serviceOrder.getProductDetails());
        entity.setProductModel(serviceOrder.getProductModel());
        entity.setClientInfos(serviceOrder.getClientInfos());
        entity.setTecInfos(serviceOrder.getTecInfos());

        var dto = mapper.convertEntityToDTO(repository.save(entity));
        return addHateoas(dto);
    }

    public void delete(Integer id){
        logger.info("Deleting one ServiceOrder");

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }

    public List<ServiceOrderDTO> findByClientName(String name){
        var dtos = mapper.convertListToDTO(repository.findByClientName(name));
        return dtos.stream().map(this::addHateoas).collect(Collectors.toList());
    }

    public List<ServiceOrderDTO> findByAnyParam(String param){
        var dtos = mapper.convertListToDTO(repository.findByAnyParam(param));
        return dtos.stream().map(this::addHateoas).collect(Collectors.toList());
    }

    private ServiceOrderDTO addHateoas(ServiceOrderDTO dto){
        dto.add(linkTo(methodOn(ServiceOrderController.class).findById(dto.getKey())).withSelfRel());
        dto.add(linkTo(methodOn(ClientController.class).findById(dto.getClient().getKey())).withRel("client"));
        return dto;
    }
}
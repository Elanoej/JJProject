package com.eletronica.JJProject.services;

import com.eletronica.JJProject.controllers.ClientController;
import com.eletronica.JJProject.controllers.ServiceOrderController;
import com.eletronica.JJProject.data.dto.v1.ClientDTO;
import com.eletronica.JJProject.exceptions.ResourceNotFoundException;
import com.eletronica.JJProject.mapper.ClientMapper;
import com.eletronica.JJProject.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ClientService {

    private Logger logger = Logger.getLogger(ClientService.class.getName());

    @Autowired
    private ClientRepository repository;

    @Autowired
    private ClientMapper mapper;

    public List<ClientDTO> findAll(){
        logger.info("Finding all clients");

        var clientDTOS = mapper.convertListToDTO(repository.findAll(Sort.by("id")));
        return clientDTOS.stream().map(this::addHateoas).collect(Collectors.toList());
    }

    public ClientDTO findById(Integer id){
        logger.info("Finding one client");

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        var dto = mapper.convertEntityToDTO(entity);
        return addHateoas(dto);
    }

    public ClientDTO create(ClientDTO clientDTO){
        logger.info("Creating one client");

        var entity = mapper.convertDTOToEntity(clientDTO);
        var dto = mapper.convertEntityToDTO(repository.save(entity));
        return addHateoas(dto);
    }

    public ClientDTO update(ClientDTO clientDTO){
        logger.info("Updating one client");

        var entity = repository.findById(clientDTO.getKey()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setName(clientDTO.getName());
        entity.setAddress(clientDTO.getAddress());
        entity.setCellphone(clientDTO.getCellphone());

        var dto = mapper.convertEntityToDTO(repository.save(entity));
        return addHateoas(dto);
    }

    public void delete(Integer id){
        logger.info("Deleting one client");

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }

    public List<ClientDTO> findByName(String name){
        var dtos = mapper.convertListToDTO(repository.findByName(name));
        return dtos.stream().map(this::addHateoas).collect(Collectors.toList());
    }

    public List<ClientDTO> findByAnyParam(String param){
        var dtos = mapper.convertListToDTO(repository.findByAnyParams(param));
        return dtos.stream().map(this::addHateoas).collect(Collectors.toList());
    }

    private ClientDTO addHateoas(ClientDTO dto){
        dto.add(linkTo(methodOn(ClientController.class).findById(dto.getKey())).withSelfRel());
        if(!dto.getServiceOrders().isEmpty()){
            dto.getServiceOrders().forEach(so -> dto.add(linkTo(methodOn(ServiceOrderController.class).findById(so.getId())).withRel("service-order")));
        }
        return dto;
    }

}

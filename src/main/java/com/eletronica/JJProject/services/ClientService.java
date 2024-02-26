package com.eletronica.JJProject.services;

import com.eletronica.JJProject.controllers.ClientController;
import com.eletronica.JJProject.controllers.SOController;
import com.eletronica.JJProject.data.vo.v1.ClientVO;
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

    public List<ClientVO> findAll(){
        logger.info("Finding all clients");

        var vos = mapper.convertListToVO(repository.findAll(Sort.by("id")));
        vos = vos.stream().map(clientVO -> {
            clientVO.add(linkTo(methodOn(ClientController.class).findById(clientVO.getKey())).withSelfRel());
            var clientSO = clientVO.getServiceOrders();
            if(!clientSO.isEmpty()){
                clientSO.forEach(serviceOrder -> clientVO.add(linkTo(methodOn(SOController.class).findById(serviceOrder.getId())).withRel("service-order")));
            }
            return clientVO;
        }).collect(Collectors.toList());
        return vos;
    }

    public ClientVO findById(Integer id){
        logger.info("Finding one client");

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        var vo = mapper.convertEntityToVO(entity);
        vo.add(linkTo(methodOn(ClientController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public ClientVO create(ClientVO clientVO){
        logger.info("Creating one client");

        var entity = mapper.convertVoToEntity(clientVO);
        var vo = mapper.convertEntityToVO(repository.save(entity));
        vo.add(linkTo(methodOn(ClientController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public ClientVO update(ClientVO clientVO){
        logger.info("Updating one client");

        var entity = repository.findById(clientVO.getKey()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setName(clientVO.getName());
        entity.setAddress(clientVO.getAddress());
        entity.setCellphone(clientVO.getCellphone());

        var vo = mapper.convertEntityToVO(repository.save(entity));
        vo.add(linkTo(methodOn(ClientController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public void delete(Integer id){
        logger.info("Deleting one client");

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }

}

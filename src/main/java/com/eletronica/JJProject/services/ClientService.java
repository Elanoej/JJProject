package com.eletronica.JJProject.services;

import com.eletronica.JJProject.data.vo.v1.ClientVO;
import com.eletronica.JJProject.exceptions.ResourceNotFoundException;
import com.eletronica.JJProject.mapper.ClientMapper;
import com.eletronica.JJProject.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ClientService {

    private Logger logger = Logger.getLogger(ClientService.class.getName());

    @Autowired
    private ClientRepository repository;

    @Autowired
    private ClientMapper mapper;

    public List<ClientVO> findAll(){
        logger.info("Finding all clients");
        return mapper.convertListToVO(repository.findAll());
    }

    public ClientVO findById(Integer id){
        logger.info("Finding one client");

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        return mapper.convertEntityToVO(entity);
    }

    public ClientVO create(ClientVO clientVO){
        logger.info("Creating one client");

        var entity = mapper.convertVoToEntity(clientVO);
        var vo = mapper.convertEntityToVO(repository.save(entity));
        return vo;
    }

    public ClientVO update(ClientVO clientVO){
        logger.info("Updating one client");

        var entity = repository.findById(clientVO.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setName(clientVO.getName());
        entity.setAddress(clientVO.getAddress());
        entity.setCellphone(clientVO.getCellphone());

        var vo = mapper.convertEntityToVO(repository.save(entity));
        return vo;
    }

    public void delete(Integer id){
        logger.info("Deleting one client");

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }

}

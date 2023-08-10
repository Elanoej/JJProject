package com.eletronica.JJProject.services;

import com.eletronica.JJProject.data.vo.v1.ServiceOrderVO;
import com.eletronica.JJProject.exceptions.ResourceNotFoundException;
import com.eletronica.JJProject.mapper.ServiceOrderMapper;
import com.eletronica.JJProject.repositories.ServiceOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class SOService {

    private Logger logger = Logger.getLogger(ProductService.class.getName());

    @Autowired
    private ServiceOrderRepository repository;

    @Autowired
    private ServiceOrderMapper mapper;

    public List<ServiceOrderVO> findAll(){
        logger.info("Finding all services-orders");

        return mapper.convertListToVO(repository.findAll());
    }

    public ServiceOrderVO findById(Integer id){
        logger.info("Finding one ServiceOrder");

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        return mapper.convertEntityToVO(entity);
    }

    public ServiceOrderVO create(ServiceOrderVO serviceVO){
        logger.info("Creating one ServiceOrder");

        var entity = mapper.convertVOToEntity(serviceVO);
        var vo = mapper.convertEntityToVO(repository.save(entity));
        return vo;
    }

    public ServiceOrderVO update(ServiceOrderVO serviceVO){
        logger.info("Updating one ServiceOrder");

        var entity = repository.findById(serviceVO.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setDate(serviceVO.getDate());
        entity.setClient(serviceVO.getClient());
        entity.setProductDetails(serviceVO.getProductDetails());
        entity.setProductModel(serviceVO.getProductModel());
        entity.setClientInfos(serviceVO.getClientInfos());
        entity.setTecInfos(serviceVO.getTecInfos());

        var vo = mapper.convertEntityToVO(repository.save(entity));
        return vo;
    }

    public void delete(Integer id){
        logger.info("Deleting one ServiceOrder");

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }
}

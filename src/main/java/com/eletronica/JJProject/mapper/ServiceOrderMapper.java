package com.eletronica.JJProject.mapper;

import com.eletronica.JJProject.data.dto.v1.ServiceOrderDTO;
import com.eletronica.JJProject.model.ServiceOrder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceOrderMapper {

    public ServiceOrderDTO convertEntityToDTO(ServiceOrder serviceOrder){
        ServiceOrderDTO dto = new ServiceOrderDTO();
        dto.setKey(serviceOrder.getId());
        dto.setDate(serviceOrder.getDate());
        dto.setClient(serviceOrder.getClient());
        dto.setProductDetails(serviceOrder.getProductDetails());
        dto.setProductModel(serviceOrder.getProductModel());
        dto.setClientInfos(serviceOrder.getClientInfos());
        dto.setTecInfos(serviceOrder.getTecInfos());
        return dto;
    }

    public ServiceOrder convertDTOToEntity(ServiceOrderDTO serviceOrderDTO){
        ServiceOrder entity = new ServiceOrder();
        entity.setId(serviceOrderDTO.getKey());
        if(serviceOrderDTO.getDate() == null){
            entity.setDate(Instant.now());
        }else{
            entity.setDate(serviceOrderDTO.getDate());
        }
        entity.setClient(serviceOrderDTO.getClient());
        entity.setProductDetails(serviceOrderDTO.getProductDetails());
        entity.setProductModel(serviceOrderDTO.getProductModel());
        entity.setClientInfos(serviceOrderDTO.getClientInfos());
        entity.setTecInfos(serviceOrderDTO.getTecInfos());
        return entity;
    }

    public List<ServiceOrderDTO> convertListToDTO(List<ServiceOrder> serviceOrders){
        List<ServiceOrderDTO> resultList = new ArrayList<>();
        serviceOrders.forEach(orderDTO -> resultList.add(convertEntityToDTO(orderDTO)));
        return resultList;
    }

    public List<ServiceOrder> convertListToEntity(List<ServiceOrderDTO> serviceOrderDTOS){
        List<ServiceOrder> resultList = new ArrayList<>();
        serviceOrderDTOS.forEach(orderDTO -> resultList.add(convertDTOToEntity(orderDTO)));
        return resultList;
    }
}

package com.eletronica.JJProject.mapper;

import com.eletronica.JJProject.data.vo.v1.ServiceOrderVO;
import com.eletronica.JJProject.model.ServiceOrder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceOrderMapper {

    public ServiceOrderVO convertEntityToVO(ServiceOrder serviceOrder){
        ServiceOrderVO vo = new ServiceOrderVO();
        vo.setKey(serviceOrder.getId());
        vo.setDate(serviceOrder.getDate());
        vo.setClient(serviceOrder.getClient());
        vo.setProductDetails(serviceOrder.getProductDetails());
        vo.setProductModel(serviceOrder.getProductModel());
        vo.setClientInfos(serviceOrder.getClientInfos());
        vo.setTecInfos(serviceOrder.getTecInfos());
        return vo;
    }

    public ServiceOrder convertVOToEntity(ServiceOrderVO serviceOrderVO){
        ServiceOrder entity = new ServiceOrder();
        entity.setId(serviceOrderVO.getKey());
        if(serviceOrderVO.getDate() == null){
            entity.setDate(Instant.now());
        }else{
            entity.setDate(serviceOrderVO.getDate());
        }
        entity.setClient(serviceOrderVO.getClient());
        entity.setProductDetails(serviceOrderVO.getProductDetails());
        entity.setProductModel(serviceOrderVO.getProductModel());
        entity.setClientInfos(serviceOrderVO.getClientInfos());
        entity.setTecInfos(serviceOrderVO.getTecInfos());
        return entity;
    }

    public List<ServiceOrderVO> convertListToVO(List<ServiceOrder> serviceOrders){
        List<ServiceOrderVO> resultList = new ArrayList<>();
        serviceOrders.forEach(orderVO -> resultList.add(convertEntityToVO(orderVO)));
        return resultList;
    }

    public List<ServiceOrder> convertListToEntity(List<ServiceOrderVO> serviceOrderVOS){
        List<ServiceOrder> resultList = new ArrayList<>();
        serviceOrderVOS.forEach(orderVO -> resultList.add(convertVOToEntity(orderVO)));
        return resultList;
    }
}

package com.eletronica.JJProject.mapper;

import com.eletronica.JJProject.data.vo.v1.ClientVO;
import com.eletronica.JJProject.model.Client;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientMapper {

    public ClientVO convertEntityToVO(Client client){
        ClientVO vo = new ClientVO();
        vo.setKey(client.getId());
        vo.setName(client.getName());
        vo.setAddress(client.getAddress());
        vo.setCellphone(client.getCellphone());
        vo.setServiceOrders(client.getServiceOrders());
        return vo;
    }

    public Client convertVoToEntity(ClientVO client){
        Client entity = new Client();
        entity.setId(client.getKey());
        entity.setName(client.getName());
        entity.setAddress(client.getAddress());
        entity.setCellphone(client.getCellphone());
        entity.setServiceOrders(client.getServiceOrders());
        return entity;
    }

    public List<ClientVO> convertListToVO(List<Client> clients){
        List<ClientVO> resultList = new ArrayList<>();
        clients.forEach(client -> resultList.add(convertEntityToVO(client)));
        return resultList;
    }

    public List<Client> convertListToEntity(List<ClientVO> voclients){
        List<Client> resultList = new ArrayList<>();
        voclients.forEach(clientVO -> resultList.add(convertVoToEntity(clientVO)));
        return resultList;
    }
}

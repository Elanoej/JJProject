package com.eletronica.JJProject.mapper;

import com.eletronica.JJProject.data.dto.v1.ClientDTO;
import com.eletronica.JJProject.model.Client;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientMapper {

    public ClientDTO convertEntityToDTO(Client client){
        ClientDTO vo = new ClientDTO();
        vo.setKey(client.getId());
        vo.setName(client.getName());
        vo.setAddress(client.getAddress());
        vo.setCellphone(client.getCellphone());
        vo.setServiceOrders(client.getServiceOrders());
        return vo;
    }

    public Client convertDTOToEntity(ClientDTO client){
        Client entity = new Client();
        entity.setId(client.getKey());
        entity.setName(client.getName());
        entity.setAddress(client.getAddress());
        entity.setCellphone(client.getCellphone());
        entity.setServiceOrders(client.getServiceOrders());
        return entity;
    }

    public List<ClientDTO> convertListToDTO(List<Client> clients){
        List<ClientDTO> resultList = new ArrayList<>();
        clients.forEach(client -> resultList.add(convertEntityToDTO(client)));
        return resultList;
    }

    public List<Client> convertListToEntity(List<ClientDTO> dtoClients){
        List<Client> resultList = new ArrayList<>();
        dtoClients.forEach(clientDTO -> resultList.add(convertDTOToEntity(clientDTO)));
        return resultList;
    }
}

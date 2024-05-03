package com.eletronica.JJProject.mapper;

import com.eletronica.JJProject.controllers.ClientController;
import com.eletronica.JJProject.controllers.ProductController;
import com.eletronica.JJProject.controllers.ServiceOrderController;
import com.eletronica.JJProject.data.dto.v1.ClientDTO;
import com.eletronica.JJProject.data.dto.v1.ProductDTO;
import com.eletronica.JJProject.data.dto.v1.SearchDTO;
import com.eletronica.JJProject.data.dto.v1.ServiceOrderDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class SearchMapper {

    public SearchDTO clientToDTO(ClientDTO clientDTO) {
        SearchDTO dto = new SearchDTO();
        dto.setKey(clientDTO.getKey());
        dto.setName(clientDTO.getName());
        dto.setType(clientDTO.getClass().getSimpleName());
        dto.add(linkTo(methodOn(ClientController.class).findById(dto.getKey())).withSelfRel());
        return dto;
    }

    public SearchDTO productToDTO(ProductDTO productDTO) {
        SearchDTO dto = new SearchDTO();
        dto.setKey(productDTO.getKey().intValue());
        dto.setName(productDTO.getName());
        dto.setType(productDTO.getClass().getSimpleName());
        dto.add(linkTo(methodOn(ProductController.class).findById(dto.getKey().longValue())).withSelfRel());
        return dto;
    }

    public SearchDTO serviceOrderToDTO(ServiceOrderDTO serviceOrderDTO) {
        SearchDTO dto = new SearchDTO();
        dto.setKey(serviceOrderDTO.getKey());
        dto.setName(serviceOrderDTO.getClient().getName());
        dto.setType(serviceOrderDTO.getClass().getSimpleName());
        dto.add(linkTo(methodOn(ServiceOrderController.class).findById(dto.getKey())).withSelfRel());
        return dto;
    }

    public List<SearchDTO> clientToList(List<ClientDTO> listDTO) {
        return listDTO.stream().map(this::clientToDTO).collect(Collectors.toList());
    }

    public List<SearchDTO> productToList(List<ProductDTO> listDTO) {
        return listDTO.stream().map(this::productToDTO).collect(Collectors.toList());
    }

    public List<SearchDTO> serviceOrderToList(List<ServiceOrderDTO> listDTO) {
        return listDTO.stream().map(this::serviceOrderToDTO).collect(Collectors.toList());
    }
}

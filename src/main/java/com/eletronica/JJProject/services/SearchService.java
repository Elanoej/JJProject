package com.eletronica.JJProject.services;

import com.eletronica.JJProject.data.dto.v1.SearchDTO;
import com.eletronica.JJProject.mapper.SearchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ServiceOrderService serviceOrderService;

    @Autowired
    private SearchMapper mapper;


    public List<SearchDTO> findAll(String search){
        List<SearchDTO> list = new ArrayList<>();
        list.addAll(mapper.clientToList(clientService.findByName(search)));
        list.addAll(mapper.productToList(productService.findByName(search)));
        list.addAll(mapper.serviceOrderToList(serviceOrderService.findByClientName(search)));
        return list;
    }
}

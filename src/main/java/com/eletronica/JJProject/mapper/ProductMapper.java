package com.eletronica.JJProject.mapper;

import com.eletronica.JJProject.data.dto.v1.ProductDTO;
import com.eletronica.JJProject.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductMapper {

    public ProductDTO convertEntityToDTO(Product product){
        ProductDTO vo = new ProductDTO();
        vo.setKey(product.getId());
        vo.setName(product.getName());
        vo.setPrice(product.getPrice());
        vo.setType(product.getType());
        vo.setQuantity(product.getQuantity());
        return vo;
    }

    public Product convertDTOToEntity(ProductDTO product){
        Product entity = new Product();
        entity.setId(product.getKey());
        entity.setName(product.getName());
        entity.setPrice(product.getPrice());
        entity.setType(product.getType());
        entity.setQuantity(product.getQuantity());
        return entity;
    }

    public List<ProductDTO> convertListToVO(List<Product> products){
        List<ProductDTO> resultList = new ArrayList<>();
        products.forEach(product -> resultList.add(convertEntityToDTO(product)));
        return resultList;
    }

    public List<Product> convertListToEntity(List<ProductDTO> voProducts){
        List<Product> resultList = new ArrayList<>();
        voProducts.forEach(productDTO -> resultList.add(convertDTOToEntity(productDTO)));
        return resultList;
    }
}

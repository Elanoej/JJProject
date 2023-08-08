package com.eletronica.JJProject.mapper;

import com.eletronica.JJProject.data.vo.v1.ProductVO;
import com.eletronica.JJProject.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductMapper {

    public ProductVO convertEntityToVO(Product product){
        ProductVO vo = new ProductVO();
        vo.setId(product.getId());
        vo.setName(product.getName());
        vo.setPrice(product.getPrice());
        vo.setType(product.getType());
        vo.setQuantity(product.getQuantity());
        return vo;
    }

    public Product convertVoToEntity(ProductVO product){
        Product entity = new Product();
        entity.setId(product.getId());
        entity.setName(product.getName());
        entity.setPrice(product.getPrice());
        entity.setType(product.getType());
        entity.setQuantity(product.getQuantity());
        return entity;
    }

    public List<ProductVO> convertListToVO(List<Product> products){
        List<ProductVO> resultList = new ArrayList<>();
        products.forEach(product -> resultList.add(convertEntityToVO(product)));
        return resultList;
    }

    public List<Product> convertListToEntity(List<ProductVO> voProducts){
        List<Product> resultList = new ArrayList<>();
        voProducts.forEach(productVO -> resultList.add(convertVoToEntity(productVO)));
        return resultList;
    }
}

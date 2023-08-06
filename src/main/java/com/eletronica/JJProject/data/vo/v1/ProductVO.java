package com.eletronica.JJProject.data.vo.v1;

import java.io.Serializable;
import java.util.Objects;

public class ProductVO implements Serializable {

    private Long id;
    private String name;
    private Double price;
    private String type;

    public ProductVO(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductVO productVO = (ProductVO) o;
        return Objects.equals(id, productVO.id) && Objects.equals(name, productVO.name) && Objects.equals(price, productVO.price) && Objects.equals(type, productVO.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, type);
    }
}

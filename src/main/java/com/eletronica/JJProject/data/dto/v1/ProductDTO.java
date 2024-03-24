package com.eletronica.JJProject.data.dto.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Objects;

@JsonPropertyOrder({ "id", "name", "price", "type", "quantity"})
public class ProductDTO extends RepresentationModel<ProductDTO> implements Serializable {

    @JsonProperty("id")
    private Long key;
    private String name;
    private Double price;
    private String type;
    private int quantity;

    public ProductDTO(){
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
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

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDTO productDTO = (ProductDTO) o;
        return quantity == productDTO.quantity && Objects.equals(key, productDTO.key) && Objects.equals(name, productDTO.name) && Objects.equals(price, productDTO.price) && Objects.equals(type, productDTO.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, name, price, type, quantity);
    }
}

package com.eletronica.JJProject.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "product")
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private String type;

    public Product(){
    }

    public Product(Long id, String name, Double price, String type){
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
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
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(price, product.price) && Objects.equals(type, product.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, type);
    }
}

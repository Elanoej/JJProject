package com.eletronica.JJProject.model;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class Address {

    private String logradouro;
    private String complemento;
    private String bairro;

    public Address() {
    }

    public Address(String logradouro, String complemento, String bairro) {
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro(){
        return bairro;
    }

    public void setBairro(String bairro){
        this.bairro = bairro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(logradouro, address.logradouro) && Objects.equals(complemento, address.complemento) && Objects.equals(bairro, address.bairro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logradouro, complemento, bairro);
    }
}

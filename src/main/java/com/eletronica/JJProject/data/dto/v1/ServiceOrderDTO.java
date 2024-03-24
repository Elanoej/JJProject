package com.eletronica.JJProject.data.dto.v1;

import com.eletronica.JJProject.model.Client;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@JsonPropertyOrder({"id", "date", "client", "productModel", "productDetails", "clientInfos", "tecInfos"})
public class ServiceOrderDTO extends RepresentationModel<ServiceOrderDTO> implements Serializable {

    @JsonProperty("id")
    private Integer key;
    private Instant date;
    private Client client;
    private String productModel;
    private String productDetails;
    private String clientInfos;
    private String tecInfos;

    public ServiceOrderDTO(){
    }

    public ServiceOrderDTO(Integer key, Instant date, Client client, String productModel, String productDetails, String clientInfos, String tecInfos) {
        this.key = key;
        this.date = date;
        this.client = client;
        this.productModel = productModel;
        this.productDetails = productDetails;
        this.clientInfos = clientInfos;
        this.tecInfos = tecInfos;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }

    public String getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(String productDetails) {
        this.productDetails = productDetails;
    }

    public String getClientInfos() {
        return clientInfos;
    }

    public void setClientInfos(String clientInfos) {
        this.clientInfos = clientInfos;
    }

    public String getTecInfos() {
        return tecInfos;
    }

    public void setTecInfos(String tecInfos) {
        this.tecInfos = tecInfos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ServiceOrderDTO that = (ServiceOrderDTO) o;
        return Objects.equals(key, that.key) && Objects.equals(date, that.date) && Objects.equals(client, that.client) && Objects.equals(productModel, that.productModel) && Objects.equals(productDetails, that.productDetails) && Objects.equals(clientInfos, that.clientInfos) && Objects.equals(tecInfos, that.tecInfos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), key, date, client, productModel, productDetails, clientInfos, tecInfos);
    }
}

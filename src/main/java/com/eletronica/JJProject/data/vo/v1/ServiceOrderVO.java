package com.eletronica.JJProject.data.vo.v1;

import com.eletronica.JJProject.model.Client;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

public class ServiceOrderVO implements Serializable {

    private Integer id;
    private Instant date;
    private Client client;
    private String productModel;
    private String productDetails;
    private String clientInfos;
    private String tecInfos;

    public ServiceOrderVO(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        ServiceOrderVO that = (ServiceOrderVO) o;
        return Objects.equals(id, that.id) && Objects.equals(date, that.date) && Objects.equals(client, that.client) && Objects.equals(productModel, that.productModel) && Objects.equals(productDetails, that.productDetails) && Objects.equals(clientInfos, that.clientInfos) && Objects.equals(tecInfos, that.tecInfos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, client, productModel, productDetails, clientInfos, tecInfos);
    }
}

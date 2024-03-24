package com.eletronica.JJProject.data.dto.v1;

import com.eletronica.JJProject.model.ServiceOrder;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@JsonPropertyOrder({ "id", "name", "address", "cellphone", "serviceOrders"})
public class ClientDTO extends RepresentationModel<ClientDTO> implements Serializable {

    @JsonProperty("id")
    private Integer key;
    private String name;
    private String address;
    private String cellphone;

    private Set<ServiceOrder> serviceOrders = new HashSet<>();

    public ClientDTO() {
    }
    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public Set<ServiceOrder> getServiceOrders() {
        return serviceOrders;
    }

    public void setServiceOrders(Set<ServiceOrder> serviceOrders) {
        this.serviceOrders = serviceOrders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ClientDTO clientDTO = (ClientDTO) o;
        return Objects.equals(key, clientDTO.key) && Objects.equals(name, clientDTO.name) && Objects.equals(address, clientDTO.address) && Objects.equals(cellphone, clientDTO.cellphone) && Objects.equals(serviceOrders, clientDTO.serviceOrders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), key, name, address, cellphone, serviceOrders);
    }
}

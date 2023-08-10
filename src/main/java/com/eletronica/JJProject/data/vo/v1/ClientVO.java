package com.eletronica.JJProject.data.vo.v1;

import com.eletronica.JJProject.model.ServiceOrder;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ClientVO implements Serializable {

    private Integer id;
    private String name;
    private String address;
    private String cellphone;

    private Set<ServiceOrder> serviceOrders = new HashSet<>();

    public ClientVO(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        ClientVO clientVO = (ClientVO) o;
        return Objects.equals(id, clientVO.id) && Objects.equals(name, clientVO.name) && Objects.equals(address, clientVO.address) && Objects.equals(cellphone, clientVO.cellphone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, cellphone);
    }
}

package com.eletronica.JJProject.repositories;

import com.eletronica.JJProject.model.ServiceOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServiceOrderRepository extends JpaRepository<ServiceOrder, Integer> {

    List<ServiceOrder> findByClientId(Integer id);

    @Query("SELECT obj FROM ServiceOrder obj WHERE UPPER(obj.client.name) LIKE CONCAT('%', UPPER(:name), '%')")
    List <ServiceOrder> findByClientName(String name);
}

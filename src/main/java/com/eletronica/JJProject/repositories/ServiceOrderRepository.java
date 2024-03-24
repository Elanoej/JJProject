package com.eletronica.JJProject.repositories;

import com.eletronica.JJProject.model.ServiceOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceOrderRepository extends JpaRepository<ServiceOrder, Integer> {

    List<ServiceOrder> findByClientId(Integer id);
}

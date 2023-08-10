package com.eletronica.JJProject.repositories;

import com.eletronica.JJProject.model.ServiceOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceOrderRepository extends JpaRepository<ServiceOrder, Integer> {
}

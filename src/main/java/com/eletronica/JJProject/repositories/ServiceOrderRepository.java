package com.eletronica.JJProject.repositories;

import com.eletronica.JJProject.model.ServiceOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServiceOrderRepository extends JpaRepository<ServiceOrder, Integer> {

    List<ServiceOrder> findByClientId(Integer id);

    @Query("SELECT obj FROM ServiceOrder obj WHERE UPPER(obj.client.name) LIKE CONCAT('%', UPPER(:name), '%')")
    List <ServiceOrder> findByClientName(String name);

    @Query(value = "SELECT so FROM ServiceOrder so WHERE"
        + " CAST(so.id AS string) = :param"
        + " or UPPER(so.client.name) LIKE CONCAT('%', UPPER(:param), '%')"
        + " or so.productModel LIKE CONCAT('%', UPPER(:param), '%')"
        + " or so.productDetails LIKE CONCAT('%', UPPER(:param), '%')"
        + " or so.clientInfos LIKE CONCAT('%', UPPER(:param), '%')"
        + " or so.tecInfos LIKE CONCAT('%', UPPER(:param), '%')"
    )
    List<ServiceOrder> findByAnyParam(String param);
}

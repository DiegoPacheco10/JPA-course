package com.dp.pizza.persistence.crud;

import com.dp.pizza.persistence.entity.OrderEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderEntityCrud extends ListCrudRepository<OrderEntity, String> {

    List<OrderEntity> findAllByDateAfter(LocalDateTime dateTime);
    List<OrderEntity> findAllByMethodIn(List<Character> methods);

    @Query(value = "SELECT * FROM pizza_order WHERE id_customer = :id", nativeQuery = true)
    List<OrderEntity> findByCustomerOrders(@Param("id") String idCustomer);
}

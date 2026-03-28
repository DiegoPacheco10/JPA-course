package com.dp.pizza.persistence.repository;

import com.dp.pizza.domain.dto.OrderDTO;
import com.dp.pizza.persistence.entity.OrderEntity;

import java.util.List;

public interface IOrderRepository {

    List<OrderDTO> getAll();

    List<OrderDTO> getTodayOrders();

    List<OrderDTO> getOutsideOrders();

    List<OrderDTO> findByCustomerOrders(String idCustomer);
}

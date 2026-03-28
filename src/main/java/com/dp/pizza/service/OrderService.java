package com.dp.pizza.service;

import com.dp.pizza.domain.dto.OrderDTO;
import com.dp.pizza.domain.dto.PizzaDTO;
import com.dp.pizza.persistence.repository.IOrderRepository;
import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final IOrderRepository orderRepository;

    @Autowired
    public OrderService(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderDTO> getAll(){
        return this.orderRepository.getAll();
    }

    public List<OrderDTO> getTodayOrders(){
        return  this.orderRepository.getTodayOrders();
    }

    public List<OrderDTO> getOutSide (){
        return this.orderRepository.getOutsideOrders();
    }

    public List<OrderDTO> findByCustomerOrder(String idCustomer){
        return this.orderRepository.findByCustomerOrders(idCustomer);
    }
}

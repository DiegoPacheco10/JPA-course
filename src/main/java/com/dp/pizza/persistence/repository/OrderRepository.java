package com.dp.pizza.persistence.repository;

import com.dp.pizza.domain.dto.OrderDTO;
import com.dp.pizza.persistence.crud.OrderEntityCrud;
import com.dp.pizza.persistence.mapper.OrderMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Repository
public class OrderRepository implements IOrderRepository{

    private final OrderEntityCrud orderEntityCrud;
    private final OrderMapper orderMapper;

    public OrderRepository(OrderEntityCrud orderEntityCrud, OrderMapper orderMapper) {
        this.orderEntityCrud = orderEntityCrud;
        this.orderMapper = orderMapper;
    }

    @Override
    public List<OrderDTO> getAll() {
        return this.orderMapper.toDto(this.orderEntityCrud.findAll());
    }

    @Override
    public List<OrderDTO> getTodayOrders() {
        LocalDateTime today = LocalDate.now().atTime(0, 0);
        return this.orderMapper.toDto(this.orderEntityCrud.findAllByDateAfter(today));
    }
    @Override
    public List<OrderDTO> getOutsideOrders(){
        List<Character> methods = Arrays.asList('D', 'C');
        return this.orderMapper.toDto(this.orderEntityCrud.findAllByMethodIn(methods));
    }

    @Override
    public List<OrderDTO> findByCustomerOrders(String idCustomer){
        return this.orderMapper.toDto(this.orderEntityCrud.findByCustomerOrders(idCustomer));
    }
}

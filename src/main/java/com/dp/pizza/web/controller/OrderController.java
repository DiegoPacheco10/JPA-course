package com.dp.pizza.web.controller;

import com.dp.pizza.domain.dto.OrderDTO;
import com.dp.pizza.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<OrderDTO>> getAll() {
        return ResponseEntity.ok(this.orderService.getAll());
    }


    @GetMapping("/today")
    public ResponseEntity<List<OrderDTO>> getTodayOrders(){
        return ResponseEntity.ok(this.orderService.getTodayOrders());
    }

    @GetMapping("/outside")
    public ResponseEntity<List<OrderDTO>> getOutsideOrders(){
        return ResponseEntity.ok(this.orderService.getOutSide());
    }

    @GetMapping("/getByCustomer")
    public ResponseEntity<List<OrderDTO>> getByCustomer(@RequestParam() String idCustomer){
        return ResponseEntity.ok(this.orderService.findByCustomerOrder(idCustomer));
    }

}

package com.dp.pizza.web.controller;

import com.dp.pizza.domain.dto.CustomerDTO;
import com.dp.pizza.domain.dto.OrderDTO;
import com.dp.pizza.service.CustomerService;
import com.dp.pizza.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/getByPhone")
    public ResponseEntity<CustomerDTO> findByPhone (@RequestParam() String phone){
        return ResponseEntity.ok(this.customerService.findByPhone(phone));
    }
}

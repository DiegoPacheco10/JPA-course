package com.dp.pizza.service;

import com.dp.pizza.domain.dto.CustomerDTO;
import com.dp.pizza.persistence.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final ICustomerRepository customerRepository;

    @Autowired
    public CustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerDTO findByPhone(String phone){
        return this.customerRepository.findByPhone(phone);
    }
}

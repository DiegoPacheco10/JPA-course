package com.dp.pizza.persistence.repository;

import com.dp.pizza.domain.dto.CustomerDTO;
import com.dp.pizza.persistence.crud.CustomerEntityCrud;
import com.dp.pizza.persistence.entity.CustomerEntity;
import com.dp.pizza.persistence.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository implements  ICustomerRepository{

    private final CustomerEntityCrud customerEntityCrud;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerRepository(CustomerEntityCrud customerEntityCrud, CustomerMapper customerMapper) {
        this.customerEntityCrud = customerEntityCrud;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerDTO findByPhone(String phone){
        return this.customerMapper.toDto(this.customerEntityCrud.findByPhone(phone));
    }



}

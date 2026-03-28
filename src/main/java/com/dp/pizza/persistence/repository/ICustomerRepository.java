package com.dp.pizza.persistence.repository;

import com.dp.pizza.domain.dto.CustomerDTO;
import com.dp.pizza.persistence.entity.CustomerEntity;

public interface ICustomerRepository {

    CustomerDTO findByPhone(String phone);
}

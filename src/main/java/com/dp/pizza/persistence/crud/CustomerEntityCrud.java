package com.dp.pizza.persistence.crud;

import com.dp.pizza.persistence.entity.CustomerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerEntityCrud extends ListCrudRepository<CustomerEntity, String> {
    @Query(value = "SELECT c FROM CustomerEntity c WHERE c.phoneNumber = :phoneNumber")
    CustomerEntity findByPhone (@Param("phoneNumber") String phone);
}

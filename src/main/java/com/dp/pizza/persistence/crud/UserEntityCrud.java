package com.dp.pizza.persistence.crud;

import com.dp.pizza.persistence.entity.UserEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface UserEntityCrud extends ListCrudRepository<UserEntity, String> {
    UserEntity findByUsername(String username);
}

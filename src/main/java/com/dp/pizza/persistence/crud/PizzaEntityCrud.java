package com.dp.pizza.persistence.crud;

import com.dp.pizza.constant.PizzaType;
import com.dp.pizza.persistence.entity.PizzaEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface PizzaEntityCrud extends ListCrudRepository<PizzaEntity, String> {
    List<PizzaEntity> findAllByAvailableTrueOrderByPrice();
    List<PizzaEntity> findAllByAvailableTrueAndNameIgnoreCase(String name);
    int countByType(PizzaType type);
}

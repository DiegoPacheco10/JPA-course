package com.dp.pizza.persistence.repository;

import com.dp.pizza.domain.dto.PizzaDTO;
import com.dp.pizza.persistence.entity.PizzaEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IPizzaRepository {

    Page<PizzaDTO> getAll(int page, int elements);
    PizzaDTO getById(String id);
    PizzaDTO save(PizzaDTO dto);
    boolean exists(String idPizza);
    void delete(String idPizza);
    Page<PizzaDTO> getAvailable(int page, int elements, String sortBy, String sortDirection);

    List<PizzaDTO> getByName(String name);

    int countVeganPizzas();
}

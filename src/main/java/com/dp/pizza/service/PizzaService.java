package com.dp.pizza.service;

import com.dp.pizza.domain.dto.PizzaDTO;
import com.dp.pizza.persistence.entity.PizzaEntity;
import com.dp.pizza.persistence.repository.IPizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {
    private  final IPizzaRepository pizzaRepository;

    @Autowired
    public PizzaService(IPizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public Page<PizzaDTO> getAll(int page, int elements){
        return  this.pizzaRepository.getAll(page, elements);
    }

    public PizzaDTO getById(String id){
        return this.pizzaRepository.getById(id);
    }

    public PizzaDTO save(PizzaDTO pizzaDTO){
        return this.pizzaRepository.save(pizzaDTO);
    }

    public boolean exists (String idPizza){
        return this.pizzaRepository.exists(idPizza);
    }

    public void delete(String idPizza) {
        this.pizzaRepository.delete(idPizza);
    }

    public Page<PizzaDTO> getAvailable(int page, int elements, String sortBy, String sortDirection){
        return this.pizzaRepository.getAvailable(page, elements, sortBy, sortDirection);
    }

    public List<PizzaDTO> getByName(String name){
        System.out.println("Total: ==== " + this.pizzaRepository.countVeganPizzas());
        return this.pizzaRepository.getByName(name);
    }


}

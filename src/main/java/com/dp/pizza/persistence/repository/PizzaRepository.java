package com.dp.pizza.persistence.repository;

import com.dp.pizza.constant.PizzaType;
import com.dp.pizza.domain.dto.PizzaDTO;
import com.dp.pizza.persistence.crud.IPizzaPagSortRepository;
import com.dp.pizza.persistence.crud.PizzaEntityCrud;
import com.dp.pizza.persistence.entity.PizzaEntity;
import com.dp.pizza.persistence.mapper.PizzaMapper;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PizzaRepository implements IPizzaRepository{

    private final PizzaEntityCrud pizzaEntityCrud;
    private final PizzaMapper pizzaMapper;
    private final IPizzaPagSortRepository pizzaPagSortRepository;

    @Autowired
    public PizzaRepository(PizzaEntityCrud pizzaEntityCrud, PizzaMapper pizzaMapper, IPizzaPagSortRepository pizzaPagSortRepository) {
        this.pizzaEntityCrud = pizzaEntityCrud;
        this.pizzaMapper = pizzaMapper;
        this.pizzaPagSortRepository = pizzaPagSortRepository;
    }

    @Override
    public Page<PizzaDTO> getAll(int page, int elements) {
        Pageable pageable = PageRequest.of(page, elements);
        return this.pizzaMapper.toPageDTO(this.pizzaPagSortRepository.findAll(pageable));
    }

    @Override
    public PizzaDTO getById(String id){

        return this.pizzaMapper.toDto(pizzaEntityCrud.findById(id).orElse(null));
    }

    @Override
    public PizzaDTO save(PizzaDTO dto){
        PizzaEntity pizzaEntity = this.pizzaMapper.toEntity(dto);
        return this.pizzaMapper.toDto(pizzaEntityCrud.save(pizzaEntity));
    }

    @Override
    public boolean exists(String idPizza){
        return this.pizzaEntityCrud.existsById(idPizza);
    }

    @Override
    public void delete(String idPizza){
        this.pizzaEntityCrud.deleteById(idPizza);
    }

    @Override
    public Page<PizzaDTO> getAvailable(int page, int elements, String sortBy, String sortDirection){

        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(page, elements, sort);
        return this.pizzaMapper.toPageDTO(this.pizzaPagSortRepository.findByAvailableTrue(pageable));
    }

    @Override
    public List<PizzaDTO> getByName(String name){
        return this.pizzaMapper.toDto(this.pizzaEntityCrud.findAllByAvailableTrueAndNameIgnoreCase(name));
    }
    @Override
    public int countVeganPizzas(){

        return this.pizzaEntityCrud.countByType(PizzaType.VEGAN);
    }
}

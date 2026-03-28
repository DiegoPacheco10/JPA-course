package com.dp.pizza.persistence.mapper;

import com.dp.pizza.domain.dto.PizzaDTO;
import com.dp.pizza.persistence.entity.PizzaEntity;
import org.mapstruct.*;
import org.springframework.data.domain.Page;

import java.util.Iterator;
import java.util.List;


@Mapper(componentModel = "spring", uses = {AvailableMapper.class})
public interface PizzaMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "nombre")
    @Mapping(source = "description", target = "descripcion")
    @Mapping(source = "price", target = "precio")
    @Mapping(source = "type", target = "tipo")
    @Mapping(source = "available", target = "disponible", qualifiedByName="availableToString")
    PizzaDTO toDto(PizzaEntity entity);
    List<PizzaDTO> toDto(Iterable<PizzaEntity> entities);

    default Page<PizzaDTO> toPageDTO(Page<PizzaEntity> entityPage) {
        return entityPage.map(this::toDto);
    }


    @InheritInverseConfiguration
    @Mapping(source = "disponible", target = "available", qualifiedByName="stringToAvailable")
    PizzaEntity toEntity(PizzaDTO dto);
}

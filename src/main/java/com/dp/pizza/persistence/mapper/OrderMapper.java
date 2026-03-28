package com.dp.pizza.persistence.mapper;

import com.dp.pizza.domain.dto.OrderDTO;
import com.dp.pizza.domain.dto.OrderItemDTO;
import com.dp.pizza.persistence.entity.OrderEntity;
import com.dp.pizza.persistence.entity.OrderItemEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PizzaMapper.class, CustomerMapper.class})
public interface OrderMapper {

    @Mapping(source = "date", target = "fecha")
    @Mapping(source = "method", target = "metodo")
    @Mapping(source = "additionalNotes", target = "notasAdicionales")
    @Mapping(source = "customer", target = "cliente")
    @Mapping(source = "items", target = "productos")
    OrderDTO toDto(OrderEntity entity);
    List<OrderDTO> toDto(List<OrderEntity> entities);

    @InheritInverseConfiguration
    OrderEntity toEntity(OrderDTO dto);

    @Mapping(source = "pizza", target = "pizza")
    @Mapping(target = "orden", ignore = true)
    OrderItemDTO toDto(OrderItemEntity entity);

}

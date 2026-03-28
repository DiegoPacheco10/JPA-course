package com.dp.pizza.persistence.mapper;

import com.dp.pizza.domain.dto.CustomerDTO;
import com.dp.pizza.persistence.entity.CustomerEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(source = "name", target = "nombre")
    @Mapping(source = "address", target = "direccion")
    @Mapping(source = "phoneNumber", target = "numeroTelefono")
    CustomerDTO toDto(CustomerEntity entity);
    List<CustomerDTO> toDto(List<CustomerEntity> entities);

    @InheritInverseConfiguration
    CustomerEntity toEntity(CustomerDTO dto);
}

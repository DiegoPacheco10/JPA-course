package com.dp.pizza.domain.dto;

import com.dp.pizza.constant.PizzaType;

public record PizzaDTO(
        String id,
        String nombre,
        String descripcion,
        Double precio,
        PizzaType tipo,
        String disponible
) {}

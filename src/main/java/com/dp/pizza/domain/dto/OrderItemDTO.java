package com.dp.pizza.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record OrderItemDTO(
        String id,
        BigDecimal cantidad,
        BigDecimal precio,
        PizzaDTO pizza,
        OrderDTO orden
) {}

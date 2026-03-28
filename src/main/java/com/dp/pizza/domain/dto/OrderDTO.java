package com.dp.pizza.domain.dto;

import java.time.LocalDateTime;
import java.util.List;

public record OrderDTO(
        String id,
        LocalDateTime fecha,
        Double total,
        Character metodo,
        String notasAdicionales,
        CustomerDTO cliente,
        List<OrderItemDTO> productos
) {}

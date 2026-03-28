package com.dp.pizza.domain.dto;

public record CustomerDTO(
        String id,
        String nombre,
        String direccion,
        String email,
        String numeroTelefono
) {}

package com.dp.pizza.persistence.mapper;

import org.mapstruct.Named;

public class AvailableMapper {

    @Named("stringToAvailable")
    public static Boolean stringToAvailable (String available){

        return switch (available){
            case "Si" -> true;
            case "No" -> false;
            default -> null;
        };

    }

    @Named("availableToString")
    public static String availableToString(Boolean available){

        if (available == null) return null;

        return available ? "Si" : "No";
    }
}

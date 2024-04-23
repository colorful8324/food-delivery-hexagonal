package com.example.fooddeliveryhexagonal.application.dto;

import com.example.fooddeliveryhexagonal.domain.model.LineFood;
import com.example.fooddeliveryhexagonal.domain.model.enums.Food;
import lombok.Data;

import java.util.Arrays;

@Data
public class LineFoodDTO {
    private String name;
    private double price;
    private int quantity;

    public boolean isValid() {
        return Arrays.stream(Food.values())
                .anyMatch(food -> food.name().equals(name)) && price > 0 && quantity > 0;
    }

    public LineFood toDomain() {
        return new LineFood(null, null, Food.valueOf(name), price, quantity);
    }
}

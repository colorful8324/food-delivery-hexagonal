package com.example.fooddeliveryhexagonal.application.dto;

import com.example.fooddeliveryhexagonal.domain.model.Order;
import com.example.fooddeliveryhexagonal.domain.model.enums.PaymentMethod;
import com.example.fooddeliveryhexagonal.domain.model.enums.Restaurant;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class OrderDTO {
    private Integer customerId;
    private List<LineFoodDTO> lineFoods;
    private Restaurant restaurant;
    private PaymentMethod paymentMethod;

    public boolean isValid() {
        return customerId <= 0 ||
                !lineFoods.stream().allMatch(LineFoodDTO::isValid) ||
                Arrays.stream(Restaurant.values()).noneMatch(restaurant -> restaurant.name().equals(restaurant.name())) ||
                Arrays.stream(PaymentMethod.values()).noneMatch(paymentMethod -> paymentMethod.name().equals(paymentMethod.name()));
    }

    public Order toDomain() {
        return new Order(null, customerId, lineFoods.stream().map(LineFoodDTO::toDomain).toList(), restaurant, paymentMethod);
    }
}
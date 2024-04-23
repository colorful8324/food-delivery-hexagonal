package com.example.fooddeliveryhexagonal.domain.model;

import com.example.fooddeliveryhexagonal.domain.model.enums.Food;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LineFood {
    private Integer id;
    private Integer orderId;
    private Food name;
    private double price;
    private int quantity;

    public double getSubTotal() {
        return price * quantity;
    }
}

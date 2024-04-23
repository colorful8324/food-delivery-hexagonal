package com.example.fooddeliveryhexagonal.application.port.in;

import com.example.fooddeliveryhexagonal.domain.model.Order;

public interface PreparingFood {
    Order prepareFood(int orderId);

    Order markFoodPrepared(int orderId);

    Order markFoodDelivered(int orderId);
}

package com.example.fooddeliveryhexagonal.application.port.in;

import com.example.fooddeliveryhexagonal.domain.model.Order;

public interface ViewOrder {
    Order findOrderById(int orderId);
}

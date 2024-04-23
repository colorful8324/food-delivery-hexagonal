package com.example.fooddeliveryhexagonal.application.port.out;

import com.example.fooddeliveryhexagonal.domain.model.Order;

public interface OrderRepository {
    Order saveOrder(Order order);

    Order findOrderById(int id);

    void cancelOrder(int id);

    Order updateOrder(Order id);

    boolean existsById(Integer orderId);
}

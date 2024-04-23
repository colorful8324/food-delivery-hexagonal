package com.example.fooddeliveryhexagonal.application.service;

import com.example.fooddeliveryhexagonal.application.port.in.PreparingFood;
import com.example.fooddeliveryhexagonal.application.port.out.OrderRepository;
import com.example.fooddeliveryhexagonal.domain.model.Order;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FoodDeliver implements PreparingFood {
    private final OrderRepository orderRepository;

    @Override
    public Order prepareFood(int orderId) {
        Order theOrder = orderRepository.findOrderById(orderId);
        return theOrder.markPreparing();
    }

    @Override
    public Order markFoodPrepared(int orderId) {
        Order theOrder = orderRepository.findOrderById(orderId);
        return theOrder.markDelivering();
    }

    @Override
    public Order markFoodDelivered(int orderId) {
        Order theOrder = orderRepository.findOrderById(orderId);
        return theOrder.markDelivered();
    }
}

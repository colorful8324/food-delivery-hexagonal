package com.example.fooddeliveryhexagonal.application.service;

import com.example.fooddeliveryhexagonal.application.dto.OrderDTO;
import com.example.fooddeliveryhexagonal.application.port.in.*;
import com.example.fooddeliveryhexagonal.application.port.out.OrderRepository;
import com.example.fooddeliveryhexagonal.application.port.out.PaymentRepository;
import com.example.fooddeliveryhexagonal.domain.model.Order;
import com.example.fooddeliveryhexagonal.domain.model.Payment;
import com.example.fooddeliveryhexagonal.domain.model.enums.PaymentMethod;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;


public class FoodOrder implements AddMoreFood, CancelOrder, PayOrder, ViewOrder, OrderFood {
    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;

    public FoodOrder(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Order findOrderById(int orderId) {
        return orderRepository.findOrderById(orderId);
    }

    @Override
    @Transactional
    public Order createOrder(OrderDTO orderDTO) {
        if (orderDTO.isValid()) {
            throw new IllegalArgumentException("Invalid order data");
        }
        Order order = orderDTO.toDomain();
        return orderRepository.saveOrder(order);
    }

    @Override
    @Transactional
    public Order updateOrder(OrderDTO orderDTO, int orderId) {
        if (orderDTO.isValid()) {
            throw new IllegalArgumentException("Invalid order data");
        }
        Order order = orderDTO.toDomain();
        return orderRepository.saveOrder(order);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Order theOrder = orderRepository.findOrderById(id);
        if (theOrder.canBeCancelled()) {
            orderRepository.cancelOrder(id);
            return;
        }
        throw new IllegalStateException("Order can't be cancelled");
    }

    @Override
    public Payment payOrder(int paymentId, PaymentMethod paymentMethod) {
        Payment payment = paymentRepository.findPaymentById(paymentId);
        Order theOrder = orderRepository.findOrderById(payment.getOrderId());
        theOrder = orderRepository.saveOrder(theOrder.markPaid());
        payment = new Payment(theOrder.getId(), paymentMethod);
        return paymentRepository.savePayment(payment);
    }

}

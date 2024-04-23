package com.example.fooddeliveryhexagonal.adapter.out;

import com.example.fooddeliveryhexagonal.adapter.out.entity.OrderEntity;
import com.example.fooddeliveryhexagonal.adapter.out.repository.OrderJpaRepository;
import com.example.fooddeliveryhexagonal.application.port.out.OrderRepository;
import com.example.fooddeliveryhexagonal.domain.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class OrderJpaAdapter implements OrderRepository {
    private final OrderJpaRepository orderJpaRepository;

    @Override
    @Transactional
    public Order saveOrder(Order order) {
        OrderEntity orderEntity = OrderEntity.fromDomain(order);
        orderJpaRepository.save(orderEntity);
        return orderEntity.toDomain();
    }

    @Override
    public Order findOrderById(int orderId) {
        Optional<OrderEntity> orderEntity = orderJpaRepository.findById(orderId);
        if (orderEntity.isEmpty()) {
            throw new RuntimeException("Order not found");
        }
        return orderEntity.get().toDomain();
    }

    @Override
    @Transactional
    public Order updateOrder(Order order) {
        return saveOrder(order);
    }

    @Override
    public boolean existsById(Integer orderId) {
        return orderJpaRepository.existsById(orderId);
    }

    @Override
    @Transactional
    public void cancelOrder(int id) {
        orderJpaRepository.deleteById(id);
    }

}

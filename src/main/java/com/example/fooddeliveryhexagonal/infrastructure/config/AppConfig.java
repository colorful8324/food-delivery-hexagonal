package com.example.fooddeliveryhexagonal.infrastructure.config;

import com.example.fooddeliveryhexagonal.application.port.out.OrderRepository;
import com.example.fooddeliveryhexagonal.application.port.out.PaymentRepository;
import com.example.fooddeliveryhexagonal.application.service.FoodOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public FoodOrder foodOrder(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        return new FoodOrder(orderRepository, paymentRepository);
    }
}

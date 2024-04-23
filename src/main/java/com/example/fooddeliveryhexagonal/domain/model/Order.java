package com.example.fooddeliveryhexagonal.domain.model;

import com.example.fooddeliveryhexagonal.domain.model.enums.OrderState;
import com.example.fooddeliveryhexagonal.domain.model.enums.PaymentMethod;
import com.example.fooddeliveryhexagonal.domain.model.enums.Restaurant;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Getter
@NoArgsConstructor
public class Order {
    private Integer id;
    private Integer customerId;
    private List<LineFood> lineFoods;
    private Restaurant restaurant;
    private PaymentMethod paymentMethod;
    private String time;
    private OrderState state;

    public Order(Integer id, Integer customerId, List<LineFood> lineFoods, Restaurant restaurant, PaymentMethod paymentMethod) {
        this.id = id;
        this.customerId = customerId;
        this.lineFoods = lineFoods;
        this.restaurant = restaurant;
        this.paymentMethod = paymentMethod;
        this.time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-M-yyyy hh:mm:ss"));
        this.state = OrderState.PAYMENT_EXPECTED;
    }

    public Order(Integer id, Integer customerId, List<LineFood> lineFoods, Restaurant restaurant, PaymentMethod paymentMethod, String time) {
        this.id = id;
        this.customerId = customerId;
        this.lineFoods = lineFoods;
        this.restaurant = restaurant;
        this.paymentMethod = paymentMethod;
        this.time = time;
        this.state = OrderState.PAYMENT_EXPECTED;
    }

    public boolean canBeCancelled() {
        return state == OrderState.PAYMENT_EXPECTED;
    }

    public Order markPaid() {
        if (state != OrderState.PAYMENT_EXPECTED) {
            throw new IllegalStateException("Order is already paid");
        }
        state = OrderState.PAID;
        return this;
    }

    public Order markPreparing() {
        if (state != OrderState.PAID) {
            throw new IllegalStateException("Order is not paid");
        }
        state = OrderState.PREPARING;
        return this;
    }

    public Order markDelivering() {
        if (state != OrderState.PREPARING) {
            throw new IllegalStateException("Order is not being prepared");
        }
        state = OrderState.DELIVERING;
        return this;
    }

    public Order markDelivered() {
        if (state != OrderState.DELIVERING) {
            throw new IllegalStateException("Order is not delivered");
        }
        state = OrderState.DELIVERED;
        return this;
    }

    public double totalPrice() {
        return lineFoods.stream().mapToDouble(LineFood::getSubTotal).sum();
    }

    public Order update(Order order) {
        if (state == OrderState.PAID) {
            throw new IllegalStateException("Order is already paid");
        }
        return new Order(id, order.getCustomerId(), order.getLineFoods(), restaurant, paymentMethod, time);
    }

}

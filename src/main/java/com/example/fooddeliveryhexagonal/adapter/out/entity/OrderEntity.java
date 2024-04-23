package com.example.fooddeliveryhexagonal.adapter.out.entity;

import com.example.fooddeliveryhexagonal.domain.model.LineFood;
import com.example.fooddeliveryhexagonal.domain.model.Order;
import com.example.fooddeliveryhexagonal.domain.model.enums.OrderState;
import com.example.fooddeliveryhexagonal.domain.model.enums.PaymentMethod;
import com.example.fooddeliveryhexagonal.domain.model.enums.Restaurant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "`order`")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer id;

    @Column(name = "order_customer_id")
    private Integer customerId;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_restaurant_id")
    private Restaurant restaurant;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_payment_method_id")
    private PaymentMethod paymentMethod;

    @Column(name = "order_time")
    private String time;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_state")
    private OrderState state;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "line_food_order_id")
    private List<LineFoodEntity> lineFoods;

    public static OrderEntity fromDomain(Order order) {
        List<LineFoodEntity> lineFoodEntityList = new ArrayList<>();
        for (LineFood lineFood : order.getLineFoods()) {
            lineFoodEntityList.add(LineFoodEntity.fromDomain(lineFood));
        }
        return new OrderEntity(
                order.getId(),
                order.getCustomerId(),
                order.getRestaurant(),
                order.getPaymentMethod(),
                order.getTime(),
                order.getState(),
                lineFoodEntityList
        );
    }

    public Order toDomain() {
        List<LineFood> lineFoods1 = new ArrayList<>();
        for (LineFoodEntity lineFoodEntity : lineFoods) {
            lineFoods1.add(lineFoodEntity.toDomain());
        }
        return new Order(id, customerId, lineFoods1, restaurant, paymentMethod, time);
    }
}

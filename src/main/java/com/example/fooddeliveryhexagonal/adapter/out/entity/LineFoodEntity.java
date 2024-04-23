package com.example.fooddeliveryhexagonal.adapter.out.entity;

import com.example.fooddeliveryhexagonal.application.dto.LineFoodDTO;
import com.example.fooddeliveryhexagonal.domain.model.LineFood;
import com.example.fooddeliveryhexagonal.domain.model.enums.Food;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "line_food")
public class LineFoodEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "line_food_id")
    private Integer id;

    @Column(name = "line_food_order_id")
    private Integer orderId;

    @Enumerated(EnumType.STRING)
    @Column(name = "line_food_name")
    private Food name;

    @Column(name = "line_food_price")
    private double price;

    @Column(name = "line_food_quantity")
    private int quantity;

    public static LineFoodEntity fromDomain(LineFood lineFood) {
        return new LineFoodEntity(
                lineFood.getId(),
                lineFood.getOrderId(),
                lineFood.getName(),
                lineFood.getPrice(),
                lineFood.getQuantity()
        );
    }

    public LineFood toDomain() {
        return new LineFood(id, orderId, name, price, quantity);
    }
}

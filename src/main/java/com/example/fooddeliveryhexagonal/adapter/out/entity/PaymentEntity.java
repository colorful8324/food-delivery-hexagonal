package com.example.fooddeliveryhexagonal.adapter.out.entity;

import com.example.fooddeliveryhexagonal.domain.model.Payment;
import com.example.fooddeliveryhexagonal.domain.model.enums.PaymentMethod;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payment")
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_order_id")
    private Integer orderId;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method_id")
    private PaymentMethod paymentMethod;

    @Column(name = "payment_time")
    private String time;

    public static PaymentEntity fromDomain(Payment payment) {
        return new PaymentEntity(payment.getOrderId(), payment.getPaymentMethod(), payment.getTime());
    }

    public Payment toDomain() {
        return new Payment(orderId, paymentMethod);
    }
}
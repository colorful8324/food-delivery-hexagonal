package com.example.fooddeliveryhexagonal.application.port.out;

import com.example.fooddeliveryhexagonal.domain.model.Payment;

public interface PaymentRepository {
    Payment findPaymentById(int id);

    Payment savePayment(Payment payment);

    boolean existsById(int orderId);
}

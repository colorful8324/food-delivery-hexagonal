package com.example.fooddeliveryhexagonal.adapter.out;

import com.example.fooddeliveryhexagonal.adapter.out.entity.PaymentEntity;
import com.example.fooddeliveryhexagonal.adapter.out.repository.PaymentJpaRepository;
import com.example.fooddeliveryhexagonal.application.port.out.PaymentRepository;
import com.example.fooddeliveryhexagonal.domain.model.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PaymentJpaAdapter implements PaymentRepository {
    private final PaymentJpaRepository paymentJpaRepository;

    @Override
    public Payment findPaymentById(int id) {
        Optional<PaymentEntity> paymentEntity = paymentJpaRepository.findById(id);
        if (paymentEntity.isPresent()) {
            return paymentEntity.get().toDomain();
        }
        throw new RuntimeException("Payment not found");
    }

    @Override
    public Payment savePayment(Payment payment) {
        PaymentEntity paymentEntity = PaymentEntity.fromDomain(payment);
        paymentJpaRepository.save(paymentEntity);
        return paymentEntity.toDomain();
    }

    @Override
    public boolean existsById(int orderId) {
        return paymentJpaRepository.existsById(orderId);
    }
}

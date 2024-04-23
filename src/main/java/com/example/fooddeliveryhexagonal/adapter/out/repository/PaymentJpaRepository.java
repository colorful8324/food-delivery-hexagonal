package com.example.fooddeliveryhexagonal.adapter.out.repository;

import com.example.fooddeliveryhexagonal.adapter.out.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PaymentJpaRepository extends JpaRepository<PaymentEntity, Integer> {
    boolean existsById(int id);
}

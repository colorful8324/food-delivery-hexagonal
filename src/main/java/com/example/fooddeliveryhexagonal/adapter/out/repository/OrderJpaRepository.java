package com.example.fooddeliveryhexagonal.adapter.out.repository;

import com.example.fooddeliveryhexagonal.adapter.out.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderJpaRepository extends JpaRepository<OrderEntity, Integer> {
    boolean existsById(Integer id);
}

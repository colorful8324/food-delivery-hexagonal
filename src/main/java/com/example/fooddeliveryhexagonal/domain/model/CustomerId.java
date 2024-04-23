package com.example.fooddeliveryhexagonal.domain.model;

import lombok.Getter;

@Getter
public class CustomerId {
    Integer id;

    public CustomerId(Integer id) {
        this.id = id;
    }
}

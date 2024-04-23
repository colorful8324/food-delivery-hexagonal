package com.example.fooddeliveryhexagonal.application.port.in;

import com.example.fooddeliveryhexagonal.domain.model.Payment;
import com.example.fooddeliveryhexagonal.domain.model.enums.PaymentMethod;

public interface PayOrder {
    Payment payOrder(int paymentId, PaymentMethod paymentMethod);
}

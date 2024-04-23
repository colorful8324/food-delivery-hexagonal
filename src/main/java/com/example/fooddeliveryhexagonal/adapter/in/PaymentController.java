package com.example.fooddeliveryhexagonal.adapter.in;

import com.example.fooddeliveryhexagonal.application.port.in.PayOrder;
import com.example.fooddeliveryhexagonal.domain.model.Payment;
import com.example.fooddeliveryhexagonal.domain.model.enums.PaymentMethod;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PayOrder payOrder;

    @PutMapping("/{orderId}")
    public Payment payOrder(@PathVariable int orderId, @RequestBody PaymentMethod paymentMethod) {
        return payOrder.payOrder(orderId, paymentMethod);
    }
}

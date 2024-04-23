package com.example.fooddeliveryhexagonal.application.port.in;

import com.example.fooddeliveryhexagonal.application.dto.OrderDTO;
import com.example.fooddeliveryhexagonal.domain.model.Order;

public interface OrderFood {
    Order createOrder(OrderDTO orderDTO);
}

package com.example.fooddeliveryhexagonal.application.port.in;

import com.example.fooddeliveryhexagonal.application.dto.OrderDTO;
import com.example.fooddeliveryhexagonal.domain.model.Order;

public interface AddMoreFood {
    Order updateOrder(OrderDTO orderDTO, int orderId);
}

package com.example.fooddeliveryhexagonal.adapter.in;

import com.example.fooddeliveryhexagonal.application.dto.OrderDTO;
import com.example.fooddeliveryhexagonal.application.port.in.AddMoreFood;
import com.example.fooddeliveryhexagonal.application.port.in.CancelOrder;
import com.example.fooddeliveryhexagonal.application.port.in.OrderFood;
import com.example.fooddeliveryhexagonal.application.port.in.ViewOrder;
import com.example.fooddeliveryhexagonal.domain.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final AddMoreFood addMoreFood;
    private final OrderFood orderFood;
    private final CancelOrder cancelOrder;
    private final ViewOrder viewOrder;

    @GetMapping("/{id}")
    public Order findOrderById(@PathVariable int id) {
        return viewOrder.findOrderById(id);
    }

    @PostMapping()
    public Order createOrder(@RequestBody OrderDTO orderDTO) {
        return orderFood.createOrder(orderDTO);
    }

    @PutMapping("{id}")
    public Order updateOrder(@RequestBody OrderDTO orderDTO, @PathVariable int id) {
        return addMoreFood.updateOrder(orderDTO, id);
    }

    @DeleteMapping("{id}")
    public void cancelOrder(@PathVariable int id) {
        cancelOrder.delete(id);
    }
}

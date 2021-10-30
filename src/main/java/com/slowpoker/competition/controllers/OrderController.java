package com.slowpoker.competition.controllers;

import com.slowpoker.competition.exception.ResourceNotFound;
import com.slowpoker.competition.models.Order;
import com.slowpoker.competition.repositories.OrderRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class OrderController {

    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("orders/{id}")
    public Order getOrder(@PathVariable Long id) throws ResourceNotFound {
        return orderRepository.findById(id).orElseThrow(() -> new ResourceNotFound("the order does not exist"));
    }

    @PostMapping("orders")
    public Order storeOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }
}

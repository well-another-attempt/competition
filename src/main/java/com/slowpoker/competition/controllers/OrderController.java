package com.slowpoker.competition.controllers;

import com.slowpoker.competition.exception.ResourceNotFound;
import com.slowpoker.competition.models.Order;
import com.slowpoker.competition.repositories.CompanyRepository;
import com.slowpoker.competition.repositories.OrderRepository;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class OrderController {

    private OrderRepository orderRepository;
    private CompanyRepository companyRepository;

    public OrderController(OrderRepository orderRepository, CompanyRepository companyRepository) {
        this.orderRepository = orderRepository;
        this.companyRepository = companyRepository;
    }

    @GetMapping("orders/{id}")
    public Order getOrder(@PathVariable Long id) throws ResourceNotFound {
        return orderRepository.findById(id).orElseThrow(() -> new ResourceNotFound("the order does not exist"));
    }


    @PostMapping("orders")
    public Order storeOrder(@RequestBody  String body) {
        JSONObject json = (JSONObject) JSONValue.parse(body);
        Order order = new Order();
        order.setOrderNumber((String) json.get("order_number"));
        order.setOrderSum(((Long) json.get("order_sum")).intValue());
        order.setClientPhoneNumber((String) json.get("phone_number"));
        order.setClientName((String) json.get("client_name"));
        order.setCompany(companyRepository.findById((Long) json.get("company_id")).get());

        return orderRepository.save(order);
    }

//    PostMapping("orders")
//    public Order storeOrder(@RequestBody  Order order) {
//        return orderRepository.save(order);
//    }
}

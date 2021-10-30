package com.slowpoker.competition.repositories;

import com.slowpoker.competition.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}

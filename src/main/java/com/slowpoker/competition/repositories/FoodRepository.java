package com.slowpoker.competition.repositories;

import com.slowpoker.competition.models.Food;
import org.springframework.data.repository.CrudRepository;

public interface FoodRepository extends CrudRepository<Food, Long> {
}

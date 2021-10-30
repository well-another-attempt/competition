package com.slowpoker.competition.controllers;

import com.slowpoker.competition.exception.ResourceNotFound;
import com.slowpoker.competition.models.Food;
import com.slowpoker.competition.repositories.FoodRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class FoodController {

    private FoodRepository foodRepository;

    public FoodController(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @GetMapping("foods")
    public Iterable<Food> getAll() {
        return foodRepository.findAll();
    }

    @GetMapping("foods/{id}")
    public Food getFood(@PathVariable  Long id) throws ResourceNotFound {
        return foodRepository.findById(id).orElseThrow(() -> new ResourceNotFound("the food does not exist"));
    }
}

package com.slowpoker.competition.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("dish")
public class Dishes {

    @GetMapping("forCategories")
    @ResponseBody
    public String dishesForCategories(@RequestParam Integer  CATEGORY_ID) {
        return "Hello World dishes form categories";
    }

    @GetMapping
    @ResponseBody
    public String dishesForId(@RequestParam Integer DISH_ID) {
        return "Hello World dish form id";
    }

}
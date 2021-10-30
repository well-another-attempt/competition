package com.slowpoker.competition.controller;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("categories")
public class Categories {

    @GetMapping
    public String categoriesAll() {
        return "Hello World all categories";
    }

    @GetMapping("CATEGORY_ID")
    @ResponseBody
    public String categoriesForId(@RequestParam Integer id ) {
        return "Hello World categories form id";
    }

}

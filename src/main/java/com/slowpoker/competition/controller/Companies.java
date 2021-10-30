package com.slowpoker.competition.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("companies")
public class Companies {

    @GetMapping
    public String companiesAll() {
        return "Hello World all companies";
    }

    @GetMapping("/COMPANY_ID")
    @ResponseBody
    public String companiesForId(@RequestParam Integer id) {
        return "Hello World companie form id";
    }

}

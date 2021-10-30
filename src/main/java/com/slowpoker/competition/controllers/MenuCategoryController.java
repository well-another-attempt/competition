package com.slowpoker.competition.controllers;

import com.slowpoker.competition.exception.ResourceNotFound;
import com.slowpoker.competition.models.MenuCategory;
import com.slowpoker.competition.repositories.MenuCategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api")
public class MenuCategoryController {

    private MenuCategoryRepository menuCategoryRepository;

    public MenuCategoryController(MenuCategoryRepository menuCategoryRepository) {
        this.menuCategoryRepository = menuCategoryRepository;
    }

    @GetMapping("menu-categories")
    public Iterable<MenuCategory> getAll() {
        return menuCategoryRepository.findAll();
    }

    @GetMapping("menu-categories/{id}")
    public MenuCategory getMenuCategory(@PathVariable  Long id) throws ResourceNotFound {
        return menuCategoryRepository.findById(id).orElseThrow(() -> new ResourceNotFound("the menu category does not exist"));
    }
}

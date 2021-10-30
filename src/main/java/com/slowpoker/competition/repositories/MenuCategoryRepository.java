package com.slowpoker.competition.repositories;

import com.slowpoker.competition.models.MenuCategory;
import org.springframework.data.repository.CrudRepository;

public interface MenuCategoryRepository extends CrudRepository<MenuCategory, Long> {
}

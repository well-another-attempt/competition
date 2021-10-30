package com.slowpoker.competition.bootstrap;


import com.slowpoker.competition.models.Company;
import com.slowpoker.competition.models.Food;
import com.slowpoker.competition.models.MenuCategory;
import com.slowpoker.competition.models.Order;
import com.slowpoker.competition.repositories.CompanyRepository;
import com.slowpoker.competition.repositories.FoodRepository;
import com.slowpoker.competition.repositories.MenuCategoryRepository;
import com.slowpoker.competition.repositories.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class CheckIfHibernateMappingCorrect implements CommandLineRunner {

    private CompanyRepository companyRepository;
    private MenuCategoryRepository menuCategoryRepository;
    private FoodRepository foodRepository;
    private OrderRepository orderRepository;

    public CheckIfHibernateMappingCorrect(CompanyRepository companyRepository, MenuCategoryRepository menuCategoryRepository, FoodRepository foodRepository, OrderRepository orderRepository) {
        this.companyRepository = companyRepository;
        this.menuCategoryRepository = menuCategoryRepository;
        this.foodRepository = foodRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Company company = companyRepository.save(new Company("first company", "first description"));
        MenuCategory menuCategory = menuCategoryRepository.save(new MenuCategory("first menu category", company));

        Food food = foodRepository.save(new Food("first food", "image url to AWS S3 Bucket", "description", 500, menuCategory));
        Food food2 = foodRepository.save(new Food("second food", "image url to AWS S3 Bucket", "description", 500, menuCategory));

        Set<Food> foods = new HashSet<>();
        foods.add(food);
        foods.add(food2);

        Order order = new Order("order number", 500, "my phone number", "my client name", company, foods);
        orderRepository.save(order);
    }
}

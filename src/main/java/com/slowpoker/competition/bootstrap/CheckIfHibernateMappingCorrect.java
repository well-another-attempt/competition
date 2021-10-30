package com.slowpoker.competition.bootstrap;


import com.slowpoker.competition.models.Institution;
import com.slowpoker.competition.models.MenuCategory;
import com.slowpoker.competition.repositories.InstitutionRepository;
import com.slowpoker.competition.repositories.MenuCategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CheckIfHibernateMappingCorrect implements CommandLineRunner {

    private InstitutionRepository institutionRepository;
//    private MenuCategoryRepository menuCategoryRepository;

    public CheckIfHibernateMappingCorrect(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
//        this.menuCategoryRepository = menuCategoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Institution inst1 = new Institution("first institution", "hello, world");
        institutionRepository.save(inst1);
        institutionRepository.findAll().forEach(System.out::println);
    }
}

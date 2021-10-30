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

    public CheckIfHibernateMappingCorrect(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

    }
}

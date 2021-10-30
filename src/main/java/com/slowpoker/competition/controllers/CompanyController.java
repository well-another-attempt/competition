package com.slowpoker.competition.controllers;

import com.slowpoker.competition.exception.ResourceNotFound;
import com.slowpoker.competition.models.Company;
import com.slowpoker.competition.repositories.CompanyRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class CompanyController {

    private CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping("companies")
    public Iterable<Company> getAll() {
        return companyRepository.findAll();
    }

    @GetMapping("companies/{id}")
    public Company getCompany(@PathVariable Long id) throws ResourceNotFound {
        return companyRepository.findById(id).orElseThrow(() -> new ResourceNotFound("the company does not exist"));
    }

}

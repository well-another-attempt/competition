package com.slowpoker.competition.repositories;

import com.slowpoker.competition.models.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company, Long> {
}

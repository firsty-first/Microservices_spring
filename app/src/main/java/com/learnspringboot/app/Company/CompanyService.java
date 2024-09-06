package com.learnspringboot.app.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllComapanies();
     boolean updateCompany(Long id, Company company);
     void createCompany(Company company);
}

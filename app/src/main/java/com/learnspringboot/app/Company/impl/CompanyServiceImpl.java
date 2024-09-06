package com.learnspringboot.app.Company.impl;

import com.learnspringboot.app.Company.Company;
import com.learnspringboot.app.Company.CompanyController;
import com.learnspringboot.app.Company.CompanyRepository;
import com.learnspringboot.app.Company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CompanyServiceImpl implements CompanyService {

private CompanyRepository companyRepository;
CompanyServiceImpl(CompanyRepository companyRepository)
{
   this.companyRepository=companyRepository;
}
    @Override
    public List<Company> getAllComapanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Long id,Company updated) {
        Optional<Company> companyOptional=companyRepository.findById(id);
        if(companyOptional.isPresent())
        {
            Company company=companyOptional.get();
            company.setJobs(updated.getJobs());
            company.setDescription(updated.getDescription());
            company.setName(updated.getName());
           companyRepository.save(company);
          return  true;
        }
        return false;
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);

    }
}

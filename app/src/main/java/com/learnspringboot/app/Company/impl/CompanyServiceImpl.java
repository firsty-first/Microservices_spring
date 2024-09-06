package com.learnspringboot.app.Company.impl;

import com.learnspringboot.app.Company.Company;
import com.learnspringboot.app.Company.CompanyRepository;
import com.learnspringboot.app.Company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
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
}

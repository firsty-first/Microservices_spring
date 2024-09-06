package com.learnspringboot.app.Company;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    CompanyService companyService;
    public CompanyController(    CompanyService companyService) {
        this.companyService=companyService;
    }
@GetMapping
    public List<Company>  getAllCompanies(){
        return companyService.getAllComapanies();
}
}

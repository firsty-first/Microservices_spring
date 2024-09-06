package com.learnspringboot.app.Company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    CompanyService companyService;
    public CompanyController(    CompanyService companyService) {
        this.companyService=companyService;
    }
@GetMapping
    public ResponseEntity<List<Company>>  getAllCompanies(){
        return new ResponseEntity<>( companyService.getAllComapanies(),HttpStatus.OK);
}
 @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company)
    {
        boolean p=companyService.updateCompany(id,company);
        if(p)
        return  new ResponseEntity<>("Company updated successfull ", HttpStatus.OK);
        else
        return  new ResponseEntity<>("Company uwith this id do not exist ", HttpStatus.NOT_FOUND);
    }
@PostMapping
    public  ResponseEntity<String> addCompany(@RequestBody Company company)
{
    companyService.createCompany(company);
    return new ResponseEntity<>("Company created succefully",HttpStatus.CREATED);
}
}

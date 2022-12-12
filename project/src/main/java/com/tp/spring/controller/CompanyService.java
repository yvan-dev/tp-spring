package com.tp.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tp.spring.dao.CompanyDao;
import com.tp.spring.interfac.CompanyServiceInterface;
import com.tp.spring.model.Apprentice;
import com.tp.spring.model.Company;

@RestController
@RequestMapping("/company")
public class CompanyService implements CompanyServiceInterface {
    @Autowired
    CompanyDao companyDao;


    @Override
    public ResponseEntity<List<Company>> getCompanyByCity(String city) {
        List<Company> company = companyDao.findByCity(city);
        if (company.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.OK).body(company);
    }

    @Override
    public ResponseEntity<List<Apprentice>> getCompanyApprentices(int id) {
        Company company = companyDao.findById(id);
        if (company == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.OK).body(company.getApprentices());
    }

    @Override
    public ResponseEntity<List<Company>> getCompanyByName() {
        List<Company> company = companyDao.findByOrderByNameAsc();
        if (company.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.OK).body(company);
    }

}

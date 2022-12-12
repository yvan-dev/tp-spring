package com.tp.spring.interfac;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tp.spring.model.Apprentice;
import com.tp.spring.model.Company;

public interface CompanyServiceInterface {
    @GetMapping("/{city}")
    public ResponseEntity<List<Company>> getCompanyByCity(@PathVariable String city);

    @GetMapping("/{id}/apprentices")
    public ResponseEntity<List<Apprentice>> getCompanyApprentices(@PathVariable int id);

    @GetMapping("/order")
    public ResponseEntity<List<Company>> getCompanyByName();
}

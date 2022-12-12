package com.tp.spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.tp.spring.model.Company;

@Service
@Repository
public interface CompanyDao extends JpaRepository<Company, Integer> {
    Company findById(int id);

    List<Company> findByCity(String City);

    List<Company> findByOrderByNameAsc();
}

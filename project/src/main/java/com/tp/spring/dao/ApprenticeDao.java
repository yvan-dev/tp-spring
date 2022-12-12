package com.tp.spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.tp.spring.model.Apprentice;

@Service
@Repository
public interface ApprenticeDao extends JpaRepository<Apprentice, Integer>  {
    Apprentice findById(int id);

    List<Apprentice> findAll();

    List<Apprentice> findByName(String name);

    List<Apprentice> findByNameContainingIgnoreCase(String namePattern);

    List<Apprentice> findBySalaryBetween(Long min, Long max);
}

package com.tp.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tp.spring.dao.ApprenticeDao;
import com.tp.spring.interfac.ApprenticeServiceInterface;
import com.tp.spring.model.Apprentice;

@RestController
@RequestMapping("/apprentice")
public class ApprenticeService implements ApprenticeServiceInterface{
    @Autowired
    ApprenticeDao apprenticeDao;

    @Override
    public ResponseEntity<Apprentice> getApprentice(int id) {
        Apprentice apprentice = apprenticeDao.findById(id);
        if (apprentice == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.OK).body(apprentice);
    }

    @Override
    public ResponseEntity<List<Apprentice>> getAllApprentices() {
        List<Apprentice> apprentices = apprenticeDao.findAll();
        if (apprentices.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.OK).body(apprentices);
    }

    @Override
    public ResponseEntity<List<Apprentice>> getApprenticesByName(String name) {
        List<Apprentice> apprentices = apprenticeDao.findByName(name);
        if (apprentices.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.OK).body(apprentices);
    }

    @Override
    public ResponseEntity<List<Apprentice>> getApprenticesLikeName(String str) {
        List<Apprentice> apprentices = apprenticeDao.findByNameContainingIgnoreCase(str);
        if (apprentices.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.OK).body(apprentices);
    }

    @Override
    public ResponseEntity<List<Apprentice>> getApprenticesSalary(Long min, Long max) {
        List<Apprentice> apprentices = apprenticeDao.findBySalaryBetween(min, max);
        if (apprentices.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.OK).body(apprentices);
    }

    @Override
    public ResponseEntity<String> addApprentice(Apprentice apprentice) {
        if (apprentice.getName() == "")
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nom obligatoire!");
        apprenticeDao.save(apprentice);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<String> deleteApprentice(int id) {
        Apprentice apprentice = apprenticeDao.findById(id);
        if (apprentice == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        apprenticeDao.delete(apprentice);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<String> updateApprentice(int id) {
        Apprentice apprentice = apprenticeDao.findById(id);
        if (apprentice == null)
            return ResponseEntity.notFound().build();
        apprenticeDao.save(apprentice);
        return ResponseEntity.ok().build();
    }

}

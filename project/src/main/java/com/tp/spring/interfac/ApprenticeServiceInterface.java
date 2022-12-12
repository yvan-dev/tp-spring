package com.tp.spring.interfac;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tp.spring.model.Apprentice;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ApprenticeServiceInterface {
    @GetMapping("/{id}")
    public ResponseEntity<Apprentice> getApprentice(@PathVariable int id);

    @GetMapping("/all")
    public ResponseEntity<List<Apprentice>> getAllApprentices();

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Apprentice>> getApprenticesByName(@PathVariable String name);

    @GetMapping("/like/{str}")
    public ResponseEntity<List<Apprentice>> getApprenticesLikeName(@PathVariable String str);

    @GetMapping("/salary/{min}/{max}")
    public ResponseEntity<List<Apprentice>> getApprenticesSalary(@PathVariable Long min, @PathVariable Long max);

    @PostMapping("/new")
    public ResponseEntity<String> addApprentice(@RequestBody Apprentice apprentice);

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteApprentice(@PathVariable int id);

    @PutMapping("/{id}")
    public ResponseEntity<String> updateApprentice(@PathVariable int id);
}

package com.example.location.controller;

import com.example.location.model.Location;
import com.example.location.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationRepository repository;

    @GetMapping
    public Iterable<Location> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Location> findById(@PathVariable int id) {
        return repository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        repository.deleteById(id);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Location location) {
        return repository.findById(location.getId()).isPresent()
                ? new ResponseEntity(repository.findById(location.getId()), HttpStatus.BAD_REQUEST)
                : new ResponseEntity(repository.save(location), HttpStatus.CREATED);
    }
}

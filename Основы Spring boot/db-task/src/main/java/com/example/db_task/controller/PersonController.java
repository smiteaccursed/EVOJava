package com.example.db_task.controller;

import com.example.db_task.dto.Person;
import com.example.db_task.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;


@RestController
public class PersonController {

    @Autowired
    private PersonRepository repository;

    @GetMapping("/person")
    public Iterable<Person> getPersons() {
        return repository.findAll();
    }

    @GetMapping("/person/{id}")
    public Optional<Person> findPersonById(@PathVariable int id) {
        return repository.findById(id);
    }
    @PostMapping("/person")
    public Person addPerson(@RequestBody Person person) {
        repository.save(person);
        return person;
    }
    @PutMapping("/person/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable int id, @RequestBody Person person)
    {
        Optional<Person> existingPerson = repository.findById(id);
        if(existingPerson.isPresent())
        {
            Person updatedPerson = existingPerson.get();
            updatedPerson.setFirstname(person.getFirstname());
            updatedPerson.setSurname(person.getSurname());
            updatedPerson.setLastname(person.getLastname());
            updatedPerson.setBirthday(person.getBirthday());
            return new ResponseEntity<>(repository.save(updatedPerson), HttpStatus.OK);
        }
        else
        {
            person.setId(id);
            return new ResponseEntity<>(repository.save(person), HttpStatus.CREATED);
        }
    }
    @DeleteMapping("/person/{id}")
    public void deletePerson(@PathVariable int id) {
        repository.deleteById(id);
    }
}
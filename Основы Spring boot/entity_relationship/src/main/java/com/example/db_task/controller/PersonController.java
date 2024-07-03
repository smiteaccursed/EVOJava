package com.example.db_task.controller;

import com.example.db_task.PersonService;
import com.example.db_task.dto.Message;
import com.example.db_task.dto.Person;
import com.example.db_task.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
public class PersonController {

    @Autowired
    private PersonRepository repository;
    @Autowired
    private PersonService personService;

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

    @PostMapping("/person/{id}/message")
    public ResponseEntity<Person> addMessage(@PathVariable int id, @RequestBody Message message) {
        return personService.addMeesageToPerson(id, message);
    }

    @GetMapping("/person/{id}/message")
    public List<Message> getMessage(@PathVariable int id)
    {
        return repository.findById(id).get().getMessages();
    }

    @GetMapping("/person/{p_id}/message/{m_id}")
    public Message getMessageById(@PathVariable int p_id, @PathVariable int m_id)
    {
        return repository.findById(p_id).get().getMessage(m_id);
    }

    @DeleteMapping("/person/{p_id}/message/{m_id}")
    public ResponseEntity<?> deleteMessage(@PathVariable int p_id, @PathVariable int m_id) {
        Optional<Person> personOptional = repository.findById(p_id);
        if (personOptional.isPresent()) {
            Person person = personOptional.get();
            boolean removed = person.getMessages().removeIf(message -> message.getId() == m_id);
            if (removed) {
                repository.save(person); // Сохраняем обновленное состояние пользователя
                return ResponseEntity.noContent().build(); // HTTP 204 No Content
            } else {
                return ResponseEntity.notFound().build(); // HTTP 404 Not Found
            }
        } else {
            return ResponseEntity.notFound().build(); // HTTP 404 Not Found
        }
    }
}
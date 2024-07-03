package com.example.db_task;

import com.example.db_task.repository.PersonRepository;
import com.example.db_task.dto.Person;
import com.example.db_task.dto.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    PersonRepository repository;

    public ResponseEntity<Person> addMeesageToPerson(int personId, Message message) {
        Optional<Person> existingPerson = repository.findById(personId);
        if(existingPerson.isPresent())
        {
            Person person = repository.findById(personId).get();
            message.setPerson(person);
            message.setTime(LocalDateTime.now());
            person.addMessage(message);
            return new ResponseEntity<>(repository.save(person), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
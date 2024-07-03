package com.example.db_task.controller;

import com.example.db_task.dto.Message;
import com.example.db_task.dto.Person;
import com.example.db_task.repository.MessageRepository;
import com.example.db_task.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class MessageController {

    @Autowired
    private MessageRepository repository;

    @PostMapping("/message")
    public Message addMessage(@RequestBody Message message)
    {
        repository.save(message);
        return message;
    }

    @PutMapping("/message/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable int id, @RequestBody Message message)
    {
        Optional<Message> existingMessage = repository.findById(id);
        if(existingMessage.isPresent())
        {
            Message updatedMessage = existingMessage.get();
            updatedMessage.setText(message.getText());
            updatedMessage.setTime(message.getTime());
            updatedMessage.setTitle(message.getTitle());
            return new ResponseEntity<>(repository.save(updatedMessage), HttpStatus.OK);
        }
        else
        {
            message.setId(id);
            return new ResponseEntity<>(repository.save(message), HttpStatus.CREATED);
        }
    }

    @DeleteMapping("/message/{id}")
    public void deleteMessage(@PathVariable int id)
    {
        repository.deleteById(id);
    }

    @GetMapping("/message")
    public Iterable<Message> getMessages()
    {
        return repository.findAll();
    }

    @GetMapping("/message/{id}")
    public Optional<Message> findMessageById(@PathVariable int id) {
        return repository.findById(id);
    }

}

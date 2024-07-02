package com.example.task14.controller;

import com.example.task14.dto.Message;
import com.example.task14.dto.Person;
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

    private List<Message> messages = new ArrayList<>(Arrays.asList(
            new Message(1, "Проверка", "aza baza", LocalDate.of(1999, 2, 3))
    ));

    @PostMapping("/message")
    public Message addMessage(@RequestBody Message message)
    {
        messages.add(message);
        return message;
    }

    @PutMapping("/message/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable int id, @RequestBody Message message)
    {
        int index = -1;
        for( Message m: messages)
        {
            if(m.getId()==id)
            {
                index = messages.indexOf(m);
                messages.set(index, message);
            }
        }
        return index == -1
                ? new ResponseEntity<>(addMessage(message), HttpStatus.CREATED)
                : new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/message/{id}")
    public void deleteMessage(@PathVariable int id)
    {
        messages.removeIf(m -> m.getId() == id);
    }
    @GetMapping("/message")
    public Iterable<Message> getMessages()
    {
        return  messages;
    }

    @GetMapping("/message/{id}")
    public Optional<Message> findMessageById(@PathVariable int id) {
        return messages.stream().filter(m -> m.getId() == id).findFirst();
    }

}

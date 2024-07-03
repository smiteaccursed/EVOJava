package com.example.db_task.dto;

import java.time.LocalDate ;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Message {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String text;
    private LocalDate  time;

    public Message(){
    }

    public Message(  String title, String text,LocalDate time )
    {
        this.title=title;
        this.text=text;
        this.time=time;
    }

    public Message( int id, String title, String text,LocalDate time )
    {
        this.id=id;
        this.title=title;
        this.text=text;
        this.time=time;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

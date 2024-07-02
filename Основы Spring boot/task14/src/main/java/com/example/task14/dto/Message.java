package com.example.task14.dto;

import java.time.LocalDate ;

public class Message {
    private int id;
    private String title;
    private String text;
    private LocalDate  time;

    public Message(){
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

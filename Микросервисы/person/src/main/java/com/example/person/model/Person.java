package com.example.person.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {
    @Id
    @GeneratedValue
    private int id;

    @NonNull private String name;
    @NonNull private String surname;
    @NonNull private String lastname;
    @NonNull private LocalDate birthday;
    @NonNull private String location;

    public Person(@NonNull String name, @NonNull String surname, @NonNull String lastname, @NonNull LocalDate birthday, @NonNull String location) {
        this.name = name;
        this.location = location;
    }

    public Integer getId() {
        return  id;
    }

    public String getLocation() {
        return location;
    }
}
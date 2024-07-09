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
        this.surname=surname;
        this.lastname=lastname;
        this.birthday=birthday;
    }

    public Integer getId() {
        return  id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location=location;
    }

    public void setName(String name)
    {
        this.name=name;
    }

    public String getName()
    {
        return name;
    }
    public void setSurname(String surname)
    {
        this.surname=surname;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setLastname(String lastname)
    {
        this.lastname=lastname;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setBirthday(@NonNull LocalDate birthday) {
        this.birthday = birthday;
    }

    public @NonNull LocalDate getBirthday() {
        return birthday;
    }
}
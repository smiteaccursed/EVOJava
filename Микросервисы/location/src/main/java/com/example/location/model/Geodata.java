package com.example.location.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Geodata {
    @Id @GeneratedValue
    int id;
    @NonNull private double lon;
    @NonNull private double lat;
    @NonNull private String name;

    public double getLat() {
        return lat;
    }
    public double getLon()
    {
        return lon;
    }

    public String getName()
    {
        return name;
    }

    public int getId()
    {
        return id;
    }

    public void setLat(@NonNull double lat) {
        this.lat = lat;
    }

    public void setLon(@NonNull double lon) {
        this.lon = lon;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }
}
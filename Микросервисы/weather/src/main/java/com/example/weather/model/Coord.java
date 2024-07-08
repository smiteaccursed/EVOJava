package com.example.weather.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Coord{
    private double lon;
    private double lat;

    public Coord(double lon, double lat)
    {
        this.lat=lat;
        this.lon=lon;
    }
}
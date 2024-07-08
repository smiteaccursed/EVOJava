package com.example.location.controller;

import com.example.location.model.Geodata;
import com.example.location.model.Weather;
import com.example.location.repository.GeodataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;


@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private GeodataRepository repository;
    private RestTemplate restTemplate;

    @GetMapping("/weather/{name}")
    public Weather redirectRequestWeather(@PathVariable String name) {
        Geodata geodata = repository.findByName(name).get();
        String url = String.format("http://localhost:8082/?lat=%s&lon=%s", geodata.getLat(), geodata.getLon());
        return restTemplate.getForObject(url, Weather.class);
    }

    @GetMapping("/{name}")
    public Optional<Geodata> getLocation(@PathVariable String name) {
        return repository.findByName(name);
    }

    @GetMapping
    public Iterable<Geodata> getLocations()
    {
        return repository.findAll();
    }

    @PutMapping("/{name}")
    public ResponseEntity<Geodata> updateLocation(@PathVariable String name, @RequestBody Geodata geodata)
    {
        Optional<Geodata> existingGeodata = repository.findByName(name);
        if(existingGeodata.isPresent())
        {
            Geodata updatedGeodata = existingGeodata.get();
            updatedGeodata.setName(geodata.getName());
            updatedGeodata.setLat(geodata.getLat());
            updatedGeodata.setLon(geodata.getLon());
            return  new ResponseEntity<>(repository.save(updatedGeodata), HttpStatus.OK);
        } else {
            return  new ResponseEntity<>(repository.save(geodata), HttpStatus.OK);
        }
    }

    @DeleteMapping("/{name}")
    public void deleteGeodata(@PathVariable String name)
    {
        repository.deleteById(repository.findByName(name).get().getId());
    }

    @PostMapping
    public Geodata save(@RequestBody Geodata geodata) {
        return repository.save(geodata);
    }

}
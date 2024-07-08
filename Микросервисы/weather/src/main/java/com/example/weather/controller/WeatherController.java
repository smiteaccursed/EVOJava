package com.example.weather.controller;

import com.example.weather.model.Coord;
import com.example.weather.model.Main;
import com.example.weather.model.Root;
import com.example.weather.model.TimeCacheData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
public class WeatherController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    HashMap<Coord, TimeCacheData> cache;

    @Value("${appID}")
    private String appId;

    @Value("${url.weather}")
    private String urlWeather;
    @Value("${cache.interval}")
    private long cahceInterval;

    @GetMapping("/weather")
    public Main getWeather(@RequestParam double lat, @RequestParam double lon) {
        long currentTime= System.currentTimeMillis();
        Coord coordination= new Coord(lon,lat);
        if(cache.containsKey(coordination))
        {
            TimeCacheData cacheData=cache.get(coordination);
            if((currentTime-cacheData.getTime2cache())<cahceInterval)
            {
                return cacheData.getRoot().getMain();
            }
        }

        String request = String.format("%s?lat=%s&lon=%s&units=metric&appid=%s",
                urlWeather, lat, lon, appId);
        Root result = restTemplate.getForObject(request, Root.class);
        TimeCacheData cachedData = new TimeCacheData(currentTime, result);
        cache.put(coordination, cachedData);
        return result.getMain();
    }
}
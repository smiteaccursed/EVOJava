package com.example.weather.configuration;

import com.example.weather.model.Coord;
import com.example.weather.model.TimeCacheData;
import com.example.weather.model.TimeCacheData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
    @Bean
    public HashMap<Coord, TimeCacheData> getCache() {
        return new HashMap<Coord, TimeCacheData>();
    }
}
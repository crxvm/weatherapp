package com.example.weatherapp.controller;

import com.example.weatherapp.service.WeatherService;
import com.example.weatherapp.view.ResultView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class WeatherController {
    private final WeatherService service;

    @Autowired
    public WeatherController(WeatherService service) {
        this.service = service;
    }

    @GetMapping(value = "/weather/get/{city}")
    public ResultView getWeatherByCity(@PathVariable("city") String city) {
        return service.getTempByCity(city);
    }
    @ResponseBody
    @GetMapping(value = "/weather/get")
    public ResultView getWeatherByCoordinates(@RequestParam String lat, @RequestParam String lon) {
        return service.getTempByCoordinates(lat, lon);
    }
}

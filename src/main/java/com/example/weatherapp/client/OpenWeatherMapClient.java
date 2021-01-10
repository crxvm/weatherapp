package com.example.weatherapp.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "weather", url = "https://api.openweathermap.org")
public interface OpenWeatherMapClient {
    @GetMapping(value = "/data/2.5/weather?q={city}&appid=c5968ed19928f47b89c26a09bfb5fd53")
    String getWeatherByCity(@PathVariable String city);

    @GetMapping(value = "/data/2.5/onecall?lat={lat}&lon={lon}&exclude=current,minutely,hourly,alerts&appid=c5968ed19928f47b89c26a09bfb5fd53")
    String getWeatherByCoordinates(@PathVariable("lat")String lat, @PathVariable("lon") String lon);
}

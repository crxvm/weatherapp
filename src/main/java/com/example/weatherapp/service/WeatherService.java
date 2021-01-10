package com.example.weatherapp.service;


import com.example.weatherapp.view.ResultView;

public interface WeatherService {
    ResultView getTempByCity(String city);
    ResultView getTempByCoordinates(String lat, String lon);
}

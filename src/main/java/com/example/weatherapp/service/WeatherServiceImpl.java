package com.example.weatherapp.service;

import com.example.weatherapp.client.OpenWeatherMapClient;
import com.example.weatherapp.view.ResultView;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {
    private final OpenWeatherMapClient client;

    @Override
    public ResultView getTempByCity(String city) {
        JSONObject jo = new JSONObject(client.getWeatherByCity(city)).getJSONObject("coord");
        return getTempByCoordinates(jo.get("lat").toString(),jo.get("lon").toString());
    }

    @Override
    public ResultView getTempByCoordinates(String lat, String lon) {
        JSONArray ja = new JSONObject(client.getWeatherByCoordinates(lat, lon)).getJSONArray("daily");
        Double max = -273.0;
        Double sum = 0.0;
        for (int i = 0; i < 5; i++) {
            Double d = Double.parseDouble(ja.getJSONObject(i).getJSONObject("temp").get("morn").toString()) - 273.0;
            if (d > max) max = d;
            sum += d;
        }
        return new ResultView(sum / 5, max);
    }
}

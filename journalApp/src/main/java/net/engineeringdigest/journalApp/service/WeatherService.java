package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.api.response.WeatherResponse;
import net.engineeringdigest.journalApp.cache.AppCache;
import net.engineeringdigest.journalApp.constants.Placeholders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${weather.api.key}") // While writing the confidential things in the properties i.e (application.yml)
    private String apiKey;

    @Autowired
    private AppCache appCache;

    //    private static final String API_URL = "https://api.weatherstack.com/current?access_key=API_KEY&query={city}";

    @Autowired
    private RestTemplate restTemplate;

    public WeatherResponse getWeather(String city) {
        String finalAPI = appCache.appCache.get(AppCache.keys.WEATHER_API).replace(Placeholders.CITY,city).replace(Placeholders.API_KEY,apiKey);
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.POST, null, WeatherResponse.class, city);
        return response.getBody();
    }
}


// 0d823e154671f908f416e661316f7d48

// https://api.weatherstack.com/current?access_key=0d823e154671f908f416e661316f7d48&query=Ahmedabad
package com.example.hello;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WeatherService {

    private final RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getWeatherForShinagawa() {
        String url = UriComponentsBuilder.fromHttpUrl("https://api.open-meteo.com/v1/forecast")
                .queryParam("latitude", "35.6213")  // 品川区の緯度
                .queryParam("longitude", "139.7345")  // 品川区の経度
                .queryParam("hourly", "temperature_2m")
                .toUriString();

        return restTemplate.getForObject(url, String.class);
    }
}

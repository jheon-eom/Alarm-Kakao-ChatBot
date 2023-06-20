package com.kakaochatbot.alarmbot.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WeatherController {
    @Value("${api.key}")
    private String key;


}

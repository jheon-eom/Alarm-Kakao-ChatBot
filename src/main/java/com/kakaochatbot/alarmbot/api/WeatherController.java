package com.kakaochatbot.alarmbot.api;

import com.kakaochatbot.alarmbot.service.KakaoService;
import com.kakaochatbot.alarmbot.service.WeatherService;
import com.kakaochatbot.alarmbot.weather.WeatherMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/weather")
@Slf4j
public class WeatherController {
    @Value("${api.weatherKey}")
    private String weatherKey;
    @Value("${api.kakaoRestApiKey}")
    private String kakaoRestApiKey;
    @Value("${api.kakaoCode}")
    private String kakaoCode;

    private final WeatherService weatherService;
    private final KakaoService kakaoService;

    public WeatherController(WeatherService weatherService, KakaoService kakaoService) {
        this.weatherService = weatherService;
        this.kakaoService = kakaoService;
    }

//    @GetMapping("/kakaoChatTest")
//    public ResponseEntity<HttpStatus> postTestKakaoChat() {
//        KakaoUtil.getAccessToken(kakaoRestApiKey, kakaoCode);
//        //KakaoUtil.sendKakaoTalk(new WeatherMessage(), "0700", kakaoRestApiKey);
//
//        return ResponseEntity.ok(HttpStatus.OK);
//    }

    @GetMapping("/morning")
    public ResponseEntity<WeatherMessage> callWeatherMorning() {
        WeatherMessage weatherMessage = weatherService.callWeatherMorning(weatherKey);

        return ResponseEntity.ok(weatherMessage);
    }

    @GetMapping("/afternoon")
    public ResponseEntity<WeatherMessage> callWeatherAfternoon() {
        WeatherMessage weatherMessage = weatherService.callWeatherAfternoon(weatherKey);

        return ResponseEntity.ok(weatherMessage);
    }

    @GetMapping("/night")
    public ResponseEntity<WeatherMessage> callWeatherNight() {
        WeatherMessage weatherMessage = weatherService.callWeatherNight(weatherKey);

        return ResponseEntity.ok(weatherMessage);
    }
}

package com.kakaochatbot.alarmbot.api;

import com.kakaochatbot.alarmbot.service.KakaoService;
import com.kakaochatbot.alarmbot.service.WeatherService;
import com.kakaochatbot.alarmbot.weather.WeatherMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{time}")
    public ResponseEntity<WeatherMessage> callWeather(@PathVariable("time") String time) {
        WeatherMessage weatherMessage = weatherService.callWeather(weatherKey, time);

        return ResponseEntity.ok(weatherMessage);
    }
}

package com.kakaochatbot.alarmbot.service;

import com.kakaochatbot.alarmbot.site.Gangnam;
import com.kakaochatbot.alarmbot.site.Osan;
import com.kakaochatbot.alarmbot.site.Pangyo;
import com.kakaochatbot.alarmbot.site.Site;
import com.kakaochatbot.alarmbot.util.HttpUtil;
import com.kakaochatbot.alarmbot.util.JsonUtil;
import com.kakaochatbot.alarmbot.weather.Weather;
import com.kakaochatbot.alarmbot.weather.WeatherCreator;
import com.kakaochatbot.alarmbot.weather.WeatherMessage;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class WeatherService {

    public WeatherMessage callWeatherMorning(String weatherKey) {
        String requestDate = extractToday();
        String requestTime = "0700";

        Site osan = new Osan();
        Site gangnam = new Gangnam();
        Site pangyo = new Pangyo();

        // 날씨 요청
        String osanWeather = HttpUtil.requestGet(weatherKey, osan, requestDate, requestTime);
        String gangnamWeather = HttpUtil.requestGet(weatherKey, gangnam, requestDate, requestTime);
        String pangyoWeather = HttpUtil.requestGet(weatherKey, pangyo, requestDate, requestTime);

        // json 데이터 파싱
        List<Weather> osanWeatherList = JsonUtil.parseJsonToObject(osanWeather);
        List<Weather> gangnamWeatherList = JsonUtil.parseJsonToObject(gangnamWeather);
        List<Weather> pangyoWeatherList = JsonUtil.parseJsonToObject(pangyoWeather);

        // 메시지 객체 생성
        return WeatherCreator.extractWeatherMessage(osanWeatherList, gangnamWeatherList, pangyoWeatherList);
    }

    public WeatherMessage callWeatherAfternoon(String weatherKey) {
        String requestDate = extractToday();
        String requestTime = "1300";

        Site osan = new Osan();
        Site gangnam = new Gangnam();
        Site pangyo = new Pangyo();

        // 날씨 요청
        String osanWeather = HttpUtil.requestGet(weatherKey, osan, requestDate, requestTime);
        String gangnamWeather = HttpUtil.requestGet(weatherKey, gangnam, requestDate, requestTime);
        String pangyoWeather = HttpUtil.requestGet(weatherKey, pangyo, requestDate, requestTime);

        // json 데이터 파싱
        List<Weather> osanWeatherList = JsonUtil.parseJsonToObject(osanWeather);
        List<Weather> gangnamWeatherList = JsonUtil.parseJsonToObject(gangnamWeather);
        List<Weather> pangyoWeatherList = JsonUtil.parseJsonToObject(pangyoWeather);

        // 메시지 객체 생성
        return WeatherCreator.extractWeatherMessage(osanWeatherList, gangnamWeatherList, pangyoWeatherList);
    }

    public WeatherMessage callWeatherNight(String weatherKey) {
        String requestDate = extractToday();
        String requestTime = "1900";

        Site osan = new Osan();
        Site gangnam = new Gangnam();
        Site pangyo = new Pangyo();

        // 날씨 요청
        String osanWeather = HttpUtil.requestGet(weatherKey, osan, requestDate, requestTime);
        String gangnamWeather = HttpUtil.requestGet(weatherKey, gangnam, requestDate, requestTime);
        String pangyoWeather = HttpUtil.requestGet(weatherKey, pangyo, requestDate, requestTime);

        // json 데이터 파싱
        List<Weather> osanWeatherList = JsonUtil.parseJsonToObject(osanWeather);
        List<Weather> gangnamWeatherList = JsonUtil.parseJsonToObject(gangnamWeather);
        List<Weather> pangyoWeatherList = JsonUtil.parseJsonToObject(pangyoWeather);

        // 메시지 객체 생성
        return WeatherCreator.extractWeatherMessage(osanWeatherList, gangnamWeatherList, pangyoWeatherList);
    }

    private String extractToday() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        return today.format(formatter);
    }
}

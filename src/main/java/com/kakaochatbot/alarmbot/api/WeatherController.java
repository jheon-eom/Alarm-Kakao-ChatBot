package com.kakaochatbot.alarmbot.api;

import com.kakaochatbot.alarmbot.site.Gangnam;
import com.kakaochatbot.alarmbot.site.Osan;
import com.kakaochatbot.alarmbot.site.Pangyo;
import com.kakaochatbot.alarmbot.site.Site;
import com.kakaochatbot.alarmbot.util.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class WeatherController {
    @Value("${api.key}")
    private String key;

    @GetMapping("/weather")
    public ResponseEntity<HttpStatus> callWeather() {
        Site osan = new Osan();
        Site gangnam = new Gangnam();
        Site pangyo = new Pangyo();

        String osanWeather = HttpUtil.requestGet(key, osan);
        String gangnamWeather = HttpUtil.requestGet(key, gangnam);
        String pangyoWeather = HttpUtil.requestGet(key, pangyo);

        return ResponseEntity.ok(HttpStatus.OK);
    }

}

package com.kakaochatbot.alarmbot.weather;

import lombok.Getter;

@Getter
public enum WeatherCategory {
    PTY("강수형태"),
    REH("습도"),
    RN1("1시간 강수량"),
    T1H("기온"),
    UUU("동서바람 성분"),
    VEC("풍향"),
    VVV("남북바람 성분"),
    WSD("풍속")
    ;

    private String category;

    WeatherCategory(String category) {
        this.category = category;
    }
}

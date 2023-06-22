package com.kakaochatbot.alarmbot.weather;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherMessage {
    private String requestTime; // 요청 시간

    private String osanREH; // 오산 습도
    private String osanRN1; // 오산 강수량
    private String osanT1H; // 오산 기온

    private String gangnamREH; // 강남 습도
    private String gangnamRN1; // 강남 강수량
    private String gangnamT1H; // 강남 기온

    private String pangyoREH; // 판교 습도
    private String pangyoRN1; // 판교 강수량
    private String pangyoT1H; // 판교 기온
}

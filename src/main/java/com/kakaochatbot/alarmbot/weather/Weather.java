package com.kakaochatbot.alarmbot.weather;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Weather {
    private String baseDate; // 발표일자
    private String baseTime; // 발표시각
    private String category; // 자료구분 코드
    private String obsrValue; // 예측값
    private int nx; // x 좌표값
    private int ny; // y 좌표값
}

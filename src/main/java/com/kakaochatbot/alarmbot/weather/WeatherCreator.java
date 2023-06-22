package com.kakaochatbot.alarmbot.weather;

import java.util.List;

public class WeatherCreator {

    public static WeatherMessage extractWeatherMessage(List<Weather> osan, List<Weather> gangnam, List<Weather> pangyo) {
        WeatherMessage weatherMessage = new WeatherMessage();

        for (Weather w : osan) {
            if (w.getCategory().equals(WeatherCategory.RN1.name())) {
                weatherMessage.setOsanRN1(WeatherCategory.RN1.getCategory() + w.getObsrValue());
            } else if (w.getCategory().equals(WeatherCategory.REH.name())) {
                weatherMessage.setOsanREH(WeatherCategory.REH.getCategory() + w.getObsrValue());
            } else if (w.getCategory().equals(WeatherCategory.T1H.name())) {
                weatherMessage.setOsanT1H(WeatherCategory.T1H.getCategory() + w.getObsrValue());
            }
        }

        for (Weather w : gangnam) {
            if (w.getCategory().equals(WeatherCategory.RN1.name())) {
                weatherMessage.setGangnamRN1(WeatherCategory.RN1.getCategory() + w.getObsrValue());
            } else if (w.getCategory().equals(WeatherCategory.REH.name())) {
                weatherMessage.setGangnamREH(WeatherCategory.REH.getCategory() + w.getObsrValue());
            } else if (w.getCategory().equals(WeatherCategory.T1H.name())) {
                weatherMessage.setGangnamT1H(WeatherCategory.T1H.getCategory() + w.getObsrValue());
            }
        }

        for (Weather w : pangyo) {
            if (w.getCategory().equals(WeatherCategory.RN1.name())) {
                weatherMessage.setPangyoRN1(WeatherCategory.RN1.getCategory() + w.getObsrValue());
            } else if (w.getCategory().equals(WeatherCategory.REH.name())) {
                weatherMessage.setPangyoREH(WeatherCategory.REH.getCategory() + w.getObsrValue());
            } else if (w.getCategory().equals(WeatherCategory.T1H.name())) {
                weatherMessage.setPangyoT1H(WeatherCategory.T1H.getCategory() + w.getObsrValue());
            }
        }

        return weatherMessage;
    }
}

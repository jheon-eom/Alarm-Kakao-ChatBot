package com.kakaochatbot.alarmbot.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kakaochatbot.alarmbot.weather.Weather;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class JsonUtil {

    public static List<Weather> parseJsonToObject(String jsonData) {
        List<Weather> weatherList = new ArrayList<>();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonData);
            JsonNode itemsNode = rootNode.path("response").path("body")
                    .path("items").path("item");

            for (JsonNode itemNode : itemsNode) {
                Weather weather = objectMapper.treeToValue(itemNode, Weather.class);
                weatherList.add(weather);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            log.error("json parse error!!!");
        }

        return weatherList;
    }
}

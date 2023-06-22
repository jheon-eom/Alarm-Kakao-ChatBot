package com.kakaochatbot.alarmbot.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.kakaochatbot.alarmbot.weather.WeatherMessage;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

@Slf4j
public class KakaoUtil {
    private static final String URL = "https://kapi.kakao.com/v2/api/talk/memo/default/send;";
    private static final String CONTENT_TYPE = "application/x-www-form-urlencoded";

    /**
     * get access token
     */
    public static void getAccessToken(String key, String code) {
        System.out.println("key = " + key);
        System.out.println("code = " + code);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String url = "https://kauth.kakao.com/oauth/token";

            ObjectNode data = JsonNodeFactory.instance.objectNode();
            data.put("grant_type", "authorization_code");
            data.put("client_id", key);
            data.put("redirect_uri", "http://localhost:8080");
            data.put("code", code);

            CloseableHttpClient httpClient = HttpClients.createDefault();

            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");


            HttpEntity entity = new StringEntity(data.toString());

            String requestBody = objectMapper.writeValueAsString(data);
            HttpEntity requestEntity = new StringEntity(requestBody, ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);

            HttpResponse response = httpClient.execute(httpPost);

            String responseBody = EntityUtils.toString(response.getEntity());
            System.out.println("Response body: " + responseBody);

            httpClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * send kakaotalk message
     */
    public static void sendKakaoTalk(WeatherMessage message, String time, String key) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(URL);
            httpPost.setHeader("Authorization", "Bearer " + key);
            httpPost.setHeader("Content-Type", CONTENT_TYPE);

            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode json = JsonNodeFactory.instance.objectNode();
            ObjectNode link = JsonNodeFactory.instance.objectNode();

            json.put("object_type", "text");
            json.put("text", "테스트 카카오톡 메시지");
            link.put("web_url", "http://localhost:8080");
            json.put("link", link);
            json.put("button_title", "날씨 확인");

            String requestBody = objectMapper.writeValueAsString(json);
            System.out.println("json request = " + requestBody);
            HttpEntity requestEntity = new StringEntity(requestBody, ContentType.APPLICATION_JSON);
            httpPost.setEntity(requestEntity);

            HttpResponse response = httpClient.execute(httpPost);
            System.out.println("===========response = " + response);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("json process error!!!");
        }
    }
}

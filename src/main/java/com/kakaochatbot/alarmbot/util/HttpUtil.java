package com.kakaochatbot.alarmbot.util;

import com.kakaochatbot.alarmbot.site.Site;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

@Slf4j
public class HttpUtil {

    public static String requestGet(String key, Site site, String today, String time) {
        String url = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst"
                + "?serviceKey=" + key
                + "&numOfRows=10"
                + "&pageNo=1"
                + "&dataType=JSON"
                + "&base_date=" + today
                + "&base_time=" + time
                + "&nx=" + site.getNx()
                + "&ny=" + site.getNy()
                ;
        log.info("request url = {}", url);

        String responseDataJson = null;

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(url);

            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
            responseDataJson = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");

            log.info("response json data = {}", responseDataJson);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("Network communication failed!!!");
        }

        return responseDataJson;
    }
}

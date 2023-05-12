/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.weather;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HttpsURLConnection;
import org.xml.sax.SAXException;

/**
 *
 * @author 032KalinichenkoOV
 */
public class WeatherService {

    public static void main(String[] args) throws IOException, SAXException {
        TimerTask repeatedTask = new TimerTask() {
            public void run() {
                getWeathers();
            }
        };
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        scheduledExecutorService.scheduleAtFixedRate(repeatedTask, 0, 1, TimeUnit.DAYS);//запуск раз в день
    }

    private static void getWeathers() {
        try {
            URL url = new URL("https://xml.meteoservice.ru/export/gismeteo/point/160.xml");
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            try (InputStream is = connection.getInputStream()) {
                XMLParser parser = new XMLParser();
                parser.readWeather(is);
            } catch (UnknownHostException e) {
                connection.disconnect();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

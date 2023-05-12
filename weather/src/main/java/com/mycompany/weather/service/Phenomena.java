/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.weather.service;

import java.util.HashMap;
import java.util.Map;
import org.w3c.dom.NamedNodeMap;

/**
 *
 * @author Olga
 */
public class Phenomena implements IWeather {

    private Map<String, Map<String, String>> param = new HashMap<>();

    @Override
    public String getString(NamedNodeMap node) {
        //инициализация параметров
        initParam();
        String result = "";
        for (String key : param.keySet()) {
            String attribute = node.getNamedItem(key).getNodeValue();
            String tag = param.get(key).get(null);
            result = String.format("%s\n%s: %s", result,tag, param.get(key).get(attribute));
        }
        return result;
    }

    private void initParam() {
        //облачность по градациям
        Map<String, String> cloudiness = new HashMap<>();
        cloudiness.put(null, "Облачность");
        cloudiness.put("-1", "туман");
        cloudiness.put("0", "ясно");
        cloudiness.put("1", "малооблачно");
        cloudiness.put("2", "облачно");
        cloudiness.put("3", "пасмурно");
        param.put("cloudiness", cloudiness);

        Map<String, String> precipitation = new HashMap<>();
        precipitation.put(null, "Осадки");
        precipitation.put("3", "смешанные");
        precipitation.put("4", "дождь");
        precipitation.put("5", "ливень");
        precipitation.put("6", "снег");
        precipitation.put("7", "снег");
        precipitation.put("8", "гроза");
        precipitation.put("9", "нет данных");
        precipitation.put("10", "без осадков");
        param.put("precipitation", precipitation);

        Map<String, String> rpower = new HashMap<>();
        rpower.put(null, "Интенсивность осадков");
        rpower.put("0", "возможен дождь/снег");
        rpower.put("1", "дождь/снег");
        param.put("rpower", rpower);

        Map<String, String> spower = new HashMap<>();
        spower.put(null, "Вероятность грозы");
        spower.put("0", "возможна гроза");
        spower.put("1", "гроза");
        param.put("rpower", spower);
    }

}

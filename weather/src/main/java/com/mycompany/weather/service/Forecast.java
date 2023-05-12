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
 * @author 032KalinichenkoOV
 */
public class Forecast implements IWeather {
    private Map<String, String> dMap = new HashMap<>();

    @Override
    public String getString(NamedNodeMap node) {
        initParam();
        String day = null, month = null, year = null,tod= null;
        for (int i = 0; i < node.getLength(); i++) {
            switch (node.item(i).getNodeName().toLowerCase()) {
                case ("day"):
                    day = node.item(i).getNodeValue();
                    break;
                case ("month"):
                    month = node.item(i).getNodeValue();
                    break;
                case ("year"):
                    year = node.item(i).getNodeValue();
                    break;
                case ("tod"):
                    tod = dMap.get(node.item(i).getNodeValue());
                    break;
            }
        }
        return String.format("\nИнформация о сроке прогнозирования:\nДата:%s.%s.%s %s", day, month, year, tod);
    }
    private void initParam() {       
        dMap.put("0", "Ночь");
        dMap.put("1", "Утро");
        dMap.put("2", "День");
        dMap.put("3", "Вечер");
    }
}

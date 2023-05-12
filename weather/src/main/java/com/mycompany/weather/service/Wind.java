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
public class Wind implements IWeather {

    private Map<String, String> dMap = new HashMap<>();
    
    @Override
    public String getString(NamedNodeMap node) {
        initParam();
        String max = null, min = null, direction= null;
        for (int i = 0; i < node.getLength(); i++) {
            switch (node.item(i).getNodeName().toLowerCase()) {
                case ("max"):
                    max = node.item(i).getNodeValue();
                    break;
                case ("min"):
                    min = node.item(i).getNodeValue();
                    break;
                case ("direction"):
                    direction = String.format("%s: %s",dMap.get(null),dMap.get(node.item(i).getNodeValue()));
                    break;
            }
        }
        return String.format("Ветер: %s м/с/%s м/с\n%s", min, max,direction);
    }

    private void initParam() {       
        dMap.put(null, "Направление ветра");
        dMap.put("1", "С");
        dMap.put("2", "СВ");
        dMap.put("3", "В");
        dMap.put("4", "ЮВ");
        dMap.put("5", "Ю");
        dMap.put("6", "ЮЗ");
        dMap.put("7", "З");
        dMap.put("8", "СЗ");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.weather.service;

import org.w3c.dom.NamedNodeMap;

/**
 *
 * @author Olga
 */
public class Temperature implements IWeather{

    @Override
    public String getString(NamedNodeMap node) {
        String max = null, min = null;
        for (int i = 0; i < node.getLength(); i++) {
            switch (node.item(i).getNodeName().toLowerCase()) {
                case ("max"):
                    max = node.item(i).getNodeValue();
                    break;
                case ("min"):
                    min = node.item(i).getNodeValue();
                    break;
            }
        }
        return String.format("Температура: %s С/%s С",min,max);
    }    
}

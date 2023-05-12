/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.weather;

import com.mycompany.weather.service.Phenomena;
import com.mycompany.weather.service.Forecast;
import com.mycompany.weather.service.Pressure;
import com.mycompany.weather.service.Temperature;
import com.mycompany.weather.service.Wind;
import java.util.stream.Stream;
import org.w3c.dom.NamedNodeMap;

/**
 *
 * @author 032KalinichenkoOV
 */
public enum TagsEnum {
    FORECAST {
        public String action(NamedNodeMap map) {
            return new Forecast().getString(map);
        }
    },
    PHENOMENA {
        public String action(NamedNodeMap map) {
            return new Phenomena().getString(map);
        }
    },
    PRESSURE {
        public String action(NamedNodeMap map) {
            return new Pressure().getString(map);
        }
    },
    TEMPERATURE {
        public String action(NamedNodeMap map) {
            return new Temperature().getString(map);
        }
    },
    WIND {
        public String action(NamedNodeMap map) {
            return new Wind().getString(map);
        }
    };  

    public static Stream<TagsEnum> stream() {
        return Stream.of(TagsEnum.values());
    }

    public abstract String action(NamedNodeMap map);   
}
      

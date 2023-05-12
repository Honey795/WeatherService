/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.weather;

import java.io.IOException;
import java.io.InputStream;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author 032KalinichenkoOV
 */
public class XMLParser {

    private Document doc;

    public Document getDoc() {
        return doc;
    }

    /*
    * Считавает содержимое xml с тэга FORECAST
    */
    public void readWeather(InputStream is) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        doc = builder.parse(is);
        doc.getDocumentElement().normalize();

        NodeList nList = doc.getDocumentElement().getElementsByTagName("FORECAST");
        parse(nList);
    }

    /*
    * Парсинг атрибутов и дочерних элементов
    */
    private void parse(NodeList list) {
        Node node = null;
        for (int i = 0; i < list.getLength(); i++) {
            node = list.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                if (node.hasAttributes()) {
                    NamedNodeMap attributes = node.getAttributes();
                    print(node.getNodeName(), attributes);//вывод на экран значения атрибутов
                }
                if (node.hasChildNodes()) {
                    parse(node.getChildNodes());
                }
            }
        }
    }

    /*
    * Выводит в консоль содержимое атрибутов
    */
    private void print(String nodeName, NamedNodeMap map) {
        TagsEnum tag = TagsEnum.stream()
                .filter(d -> d.name().toUpperCase().equals(nodeName))
                .findFirst()
                .orElse(null);//.get().action(map);
        if (tag != null) {
            System.out.println(tag.action(map));
        }
    }
}

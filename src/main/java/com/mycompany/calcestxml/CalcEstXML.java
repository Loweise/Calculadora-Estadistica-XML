package com.mycompany.calcestxml;

/** @author Zahid */

import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
public class CalcEstXML {

    public static void main(String[] args) {
        ArrayList<Double> listaEdades = new ArrayList<>();
        ArrayList<Double> listaScreenTime = new ArrayList<>();
        
        try {
            
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("user_behavior_dataset.xml"));
            doc.getDocumentElement().normalize();
            NodeList listaRecords = doc.getElementsByTagName("record");
            
            for (int i = 0; i < listaRecords.getLength(); i++) {
                Node nodo = listaRecords.item(i);
                
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element record = (Element) nodo;
                    
                    double age = Double.parseDouble(record.getElementsByTagName("age").item(0).getTextContent());
                    double use_mins = Double.parseDouble(record.getElementsByTagName("app_usage_time_minutes").item(0).getTextContent());
                    double screen_time = Double.parseDouble(record.getElementsByTagName("screen_time_hours").item(0).getTextContent());
                    double battery_drain = Double.parseDouble(record.getElementsByTagName("battery_drain").item(0).getTextContent());
                    double apps_installed = Double.parseDouble(record.getElementsByTagName("apps_installed").item(0).getTextContent());
                    double data_usage_mb_day = Double.parseDouble(record.getElementsByTagName("data_usage_mb_day").item(0).getTextContent());
                }
                
            }
            
            
            
        } catch (Exception e) {
            System.out.println("Error al leer el archivo");
            e.printStackTrace();
        }
    }
}

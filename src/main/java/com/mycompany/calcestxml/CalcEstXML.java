package com.mycompany.calcestxml;

/** @author Zahid */

import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
public class CalcEstXML {

    public static void main(String[] args) {
        try {
            
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("user_behavior_dataset.xml"));
            doc.getDocumentElement().normalize();
            NodeList listaRecords = doc.getElementsByTagName("record");
            
            // 3. Iterar sobre la lista de equipos
            for (int i = 0; i < listaRecords.getLength(); i++) {
                Node nodo = listaRecords.item(i);
                
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element record = (Element) nodo;
                    System.out.println(listaRecords.item(i));
                    double age = Double.parseDouble(record.getAttribute("nombre"));
                    double use_mins = Double.parseDouble(record.getAttribute("app_usage_time_minutes"));
                    double screen_time = Double.parseDouble(record.getAttribute("screen_time_hours"));
                    double battery_drain = Double.parseDouble(record.getAttribute("battery_drain"));
                    double apps_installed = Double.parseDouble(record.getAttribute("apps_installed"));
                    double data_usage_mb_day = Double.parseDouble(record.getAttribute("data_usage_mb_day"));
                    System.out.println(age);
                    System.out.println(use_mins);
                }
                
            }
            
            
            
        } catch (Exception e) {
            System.out.println("Error al leer el archivo");
            System.err.println(e);
        }
    }
}

package com.mycompany.calcestxml;

/** @author Zahid */

import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.util.Scanner;

public class CalcEstXML {

    public static void main(String[] args) {
        ArrayList<Double> listaEdades = new ArrayList<>();
        ArrayList<Double> listaUseMins = new ArrayList<>();
        ArrayList<Double> listaScreenTime = new ArrayList<>();
        ArrayList<Double> listaBatteryDrain = new ArrayList<>();
        ArrayList<Double> listaAppsInstalled = new ArrayList<>();
        ArrayList<Double> listaUsageMbDay = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        try {
            
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("user_behavior_dataset.xml"));
            doc.getDocumentElement().normalize();
            NodeList listaRecords = doc.getElementsByTagName("record");
            
            for (int i = 0; i < listaRecords.getLength(); i++) {
                Node nodo = listaRecords.item(i);
                
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element record = (Element) nodo;
                    
                    double age = Double.parseDouble(record.getElementsByTagName("age").item(0).getTextContent());
                    double useMins = Double.parseDouble(record.getElementsByTagName("app_usage_time_minutes").item(0).getTextContent());
                    double screenTime = Double.parseDouble(record.getElementsByTagName("screen_time_hours").item(0).getTextContent());
                    double batteryDrain = Double.parseDouble(record.getElementsByTagName("battery_drain").item(0).getTextContent());
                    double appsInstalled = Double.parseDouble(record.getElementsByTagName("apps_installed").item(0).getTextContent());
                    double dataUsageMbDay = Double.parseDouble(record.getElementsByTagName("data_usage_mb_day").item(0).getTextContent());
                    
                    listaEdades.add(age);
                    listaUseMins.add(useMins);
                    listaScreenTime.add(screenTime);
                    listaBatteryDrain.add(batteryDrain);
                    listaAppsInstalled.add(appsInstalled);
                    listaUsageMbDay.add(dataUsageMbDay); 
                }
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo");
            e.printStackTrace();
        }
        
        System.out.println("Que datos desea analizar");
        System.out.println("1.-Edad");
        System.out.println("2.-Tiempo de uso de apps (minutos)");
        System.out.println("3.-Tiempo de pantalla");
        System.out.println("4.-Drenado de bateria");
        System.out.println("5.-apps instaladas");
        System.out.println("6.-Uso de data mb/dia");
        System.out.println("7.-Cerrar menu");
        int seleccion = sc.nextInt();
        
        switch(seleccion){
            case 1:
                menuCalculos(listaEdades, sc);
                break;
            case 2:
                menuCalculos(listaUseMins, sc);
            break;
            case 3:
                menuCalculos(listaScreenTime, sc);
            break;
            case 4:
                menuCalculos(listaBatteryDrain, sc);
            break;
            case 5:
                menuCalculos(listaAppsInstalled, sc);
            break;
            case 6:
                menuCalculos(listaUsageMbDay, sc);
            break;
        }
        
    }
    
    public static void menuCalculos(ArrayList<Double> lista, Scanner sc) {
        System.out.println("Que desea calcular?");
                System.out.println("1.-Media");
                System.out.println("2.-Valor Maximo");
                System.out.println("3.-Valor min");
                System.out.println("4.-Varianza");
                System.out.println("5.-Desviacion estandar");
                int seleccionDos = sc.nextInt();
                
                switch(seleccionDos) {
                    case 1:
                        System.out.println(funciones_mat.Media(lista));
                        
                    break;
                    case 2: 
                        System.out.println(funciones_mat.valorMax(lista));
                        
                    break;
                    case 3: 
                        System.out.println(funciones_mat.valorMin(lista));
                    break;
                    case 4: 
                        System.out.println(funciones_mat.varianza(lista));
                    break;    
                    case 5: 
                        System.out.println(funciones_mat.desviacionEstandar(lista));
                    break;
                    default:
                        System.out.println("El sistema se ha cebado");
                    break;
                }
        
    }
}

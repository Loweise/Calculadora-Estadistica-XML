/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calcestxml;

import java.util.ArrayList;

/**
 *
 * @author PC LUIS
 */
public class funciones_mat {
    
    public static double Media(ArrayList<Double> lista) {
        double media =0;
        int contador=0;
        
        for (Double aDouble : lista) {
            media = media+aDouble;
            contador++;
        }
        media = media/contador;
        return media;
    }
    
    public static double valorMax(ArrayList<Double> lista){
        double vMax = lista.getFirst();
        for (Double aDouble : lista) {
            if(vMax<aDouble) { vMax = aDouble; }
        }
        return vMax;
    }
    
    public static double valorMin(ArrayList<Double> lista){
        double vMin = lista.getFirst();
        for (Double aDouble : lista) {
            if(aDouble<vMin){  vMin = aDouble; }
        }
        return vMin;
    }
    
    public static double varianza(ArrayList<Double> lista){
        double media = Media(lista), x = 0;
        
        for (Double aDouble : lista) { x = x + Math.pow((aDouble+media), 2); }
        
        return x/lista.size();
    }
    
    public static double desviacionEstandar(ArrayList<Double> lista) {
        return Math.sqrt(varianza(lista));
    }
    
}

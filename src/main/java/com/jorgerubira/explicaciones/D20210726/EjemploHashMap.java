/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.explicaciones.D20210726;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author PC
 */
class Ciudad{
    private String nombre;
    private int poblacion;

    public Ciudad(String nombre, int poblacion) {
        this.nombre = nombre;
        this.poblacion = poblacion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPoblacion() {
        return poblacion;
    }
    
    
}

public class EjemploHashMap {
    
    public static void metodos1(int ... variable){
        for(int a:variable){
            System.out.print(a);
        }
    }
    
    public static void main(String[] args) {
        metodos1(1,2,3);
        metodos1(1,2,3,5);
        metodos1(1,2,3,5,6);
        
        Map<String, Ciudad> mapa1=new HashMap<>();
        Map<String, Ciudad> mapa2=new LinkedHashMap<>();    //Order de inserción.
        Map<String, Ciudad> mapa3=new TreeMap<>();      //Ordenado por la clave.
        
        Map<String, Ciudad> mapaInm=Map.of("aaa", new Ciudad("Madrid", 0), "bbb", new Ciudad("Zaragoza",44));
        
        mapa1.put("madrid", new Ciudad("Madrid", 8000000));
        mapa1.put("aaa", new Ciudad("Zaragoza", 2000000));
        mapa1.put("aaa", new Ciudad("Teruel", 2000000));    //Reemplaza el que ya hay.
        mapa1.put("bbb", new Ciudad("Teruel", 2000000));    //Lo inserta por que la clave es diferente.
        
        mapa1.get("madrid");
        for (Ciudad c:mapa1.values()) {
            System.out.print(c.getNombre());
        }
        
        for (String k:mapa1.keySet()) {
            System.out.print(k);
        }
        if (mapa1.containsKey("aaa")==false){   //Preguntar si hay una clave antes de insertar.
            
        }

        
    }
}

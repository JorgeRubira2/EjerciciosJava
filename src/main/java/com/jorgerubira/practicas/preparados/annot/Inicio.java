package com.jorgerubira.practicas.preparados.annot;

import java.lang.reflect.Method;


public class Inicio {
    
    public static void ejecutarConReflexion(MiClase obj){
        Method[] metodos=obj.getClass().getMethods();
        for (Method metodo : metodos) {
            System.out.println(metodo.getName());
            if (metodo.isAnnotationPresent(MiAnotacion.class)){
                try{
                    metodo.invoke(obj);    
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static void main(String[] args) {
        ejecutarConReflexion(new MiClase());
    }
}

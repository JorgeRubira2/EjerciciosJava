/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.explicaciones.D20210903.anotacion;

import com.jorgerubira.explicaciones.D20210901.anotaciones.PersonaFiesta;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 *
 * @author PC
 */
public class MiClase {
    
    @MiAnotacion(dato1 = "Esto es un texto de configuracion", dato2 = 3)
    public void mimetodo(){
    }
    
    @MiAnotacion(dato1 = "Este es otro metodo")
    public void mimetodo2(){
    }    
    
    public static void reflexivo(){
        MiClase obj=new MiClase();
        Method[] metodos= obj.getClass().getMethods();
        for (Method metodo : metodos) {
            if (metodo.isAnnotationPresent(MiAnotacion.class)){
                try{
                    MiAnotacion anotacion=metodo.getAnnotation(MiAnotacion.class);
                    System.out.println(metodo.getName() + " " + 
                                        anotacion.dato1() + " " + 
                                        anotacion.dato2());
                    metodo.invoke(obj);    
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }        
    }    
    
    public static void main(String[] args) {
        reflexivo();
    }
    
    
}

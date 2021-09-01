/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.explicaciones.D20210901.anotaciones;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Data
@RequestMapping
public class Principal {

    //@Autowired
    private int a;
    
    //@PathVariable
    private int b;
    
    @Bean
    @RequestMapping
    public String dato(){
        return "hola";
    }
    
    @GetMapping
    public void param(@PathVariable String texto){
        
    }

    public static void p(){
        System.out.println("Prueba");
    }

    /**    
     * @deprecated Ejecuta mejor p
     */
    @Deprecated
    public static void prueba(){
        System.out.println("Prueba");
    }
    
    @SuppressWarnings("deprecation")
    public static void metodo(){
        prueba();
    }
    
    public static void CelebrarFiesta(){
        System.out.println("Fiesta ........................");
    }
    
    public static void EjecutarReflexionSinParametros(PersonaFiesta obj, Class<? extends Annotation> claseAnotacion){
        Method[] metodos= obj.getClass().getMethods();
        for (Method metodo : metodos) {
            if (metodo.isAnnotationPresent(claseAnotacion)){
                try{
                    metodo.invoke(obj);    
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }        
    }
    
    public static void main(String[] args) {
        PersonaFiesta pf=new PersonaFiesta();
        EjecutarReflexionSinParametros(pf, AntesDeLaFiesta.class);
        CelebrarFiesta();
        EjecutarReflexionSinParametros(pf, DespuesDeLaFiesta.class);
    }
}



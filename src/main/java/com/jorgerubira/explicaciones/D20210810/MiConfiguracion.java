/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.explicaciones.D20210810;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MiConfiguracion {
    
    @Value("${tipoEntorno}")      //Obtener información del application.properties.
    private String tipo;    //Desarrollo
    
    @Bean 
    public List<PersonaBean> obtenerListaPersonas(){
        List<PersonaBean> lista=new ArrayList<>();
        if ("desarrollo".equals(tipo)){
            lista.add(new PersonaBean(1L,"Ana","Lopez","C/Royo"));
            lista.add(new PersonaBean(2L,"Juan","Suarez","C/Royo"));
            lista.add(new PersonaBean(3L,"Fran","Perez","C/Royo"));
        }
        return lista;
    }
    
    /*@Bean
    public PersonaBean obtenerPersona(){
        return new PersonaBean(1L,"Ana","Lopez","C/Royo");
    } */   
    
    @Bean
    public List<String> obtenerNombres(){
        List<String> nombres=new ArrayList<>();
        if ("desarrollo".equals(tipo)){
            nombres.add("Ana");
            nombres.add("Juan");
            nombres.add("Pepe");
        }
        return nombres;
        
    }

    
    
}

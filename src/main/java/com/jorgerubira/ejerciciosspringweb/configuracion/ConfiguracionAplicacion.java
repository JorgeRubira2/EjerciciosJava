package com.jorgerubira.ejerciciosspringweb.configuracion;

import com.jorgerubira.ejerciciosspringweb.domain.Alumno;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

@Configuration
public class ConfiguracionAplicacion {
    
    /**
     * Creación de Beans para la aplicación.
     */
    
    /*@Bean
    public Alumno getAlumno(){
        return new Alumno(0, "Alumno creado con Bean","",""); 
    }*/
}

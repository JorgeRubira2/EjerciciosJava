package com.jorgerubira.ejerciciosspringweb.configuracion;

import com.jorgerubira.ejerciciosspringweb.domain.Alumno;
import com.jorgerubira.ejerciciosspringweb.domain.TareaKanban;
import com.jorgerubira.explicaciones.D20210810.PersonaBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

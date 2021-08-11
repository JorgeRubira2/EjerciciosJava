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

    @Value("${tipoEntorno}")      //Obtener información del application.properties.
    private String tipo;    //Desarrollo

    @Bean
    public List<TareaKanban> obtenerListatareas(){
        List<TareaKanban> lista=new ArrayList<>();
        if ("desarrollo".equals(tipo)){
            lista.add(new TareaKanban(UUID.randomUUID().toString(),"Tarea 1",null, 0, 0, "Roadmap"));
            lista.add(new TareaKanban(UUID.randomUUID().toString(),"Tarea 2",null, 0, 0, "Waiting"));
            lista.add(new TareaKanban(UUID.randomUUID().toString(),"Tarea 3",null, 0, 0, "Working"));
            lista.add(new TareaKanban(UUID.randomUUID().toString(),"Tarea 4",null, 0, 0, "Waiting"));
            lista.add(new TareaKanban(UUID.randomUUID().toString(),"Tarea 5",null, 0, 0, "Done"));
            lista.add(new TareaKanban(UUID.randomUUID().toString(),"Tarea 6",null, 0, 0, "Roadmap"));
            lista.add(new TareaKanban(UUID.randomUUID().toString(),"Tarea 7",null, 0, 0, "Done"));
            lista.add(new TareaKanban(UUID.randomUUID().toString(),"Tarea 8",null, 0, 0, "Working"));
            lista.add(new TareaKanban(UUID.randomUUID().toString(),"Tarea 9",null, 0, 0, "Waiting"));
            lista.add(new TareaKanban(UUID.randomUUID().toString(),"Tarea 10",null, 0, 0, "Roadmap"));
        }
        return lista;
    }
}

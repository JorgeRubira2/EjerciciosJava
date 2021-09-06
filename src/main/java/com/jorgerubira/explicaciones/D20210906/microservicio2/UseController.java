/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.explicaciones.D20210906.microservicio2;

import com.jorgerubira.explicaciones.D20210902.relaciones.entities.Persona;
import com.jorgerubira.explicaciones.D20210906.microservicio2.feign.PersonasFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/microservicio2")
public class UseController {
    
    @Autowired
    private PersonasFeign personas;
    
    @GetMapping()
    public String getApellido(){
        return personas.leerPersona().getApellidos();
        
    } 
    
}

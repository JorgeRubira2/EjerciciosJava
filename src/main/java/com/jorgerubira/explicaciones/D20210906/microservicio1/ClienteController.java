/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.explicaciones.D20210906.microservicio1;

import com.jorgerubira.explicaciones.D20210902.relaciones.entities.Persona;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/microservicio1")
public class ClienteController {
    
    @GetMapping
    public Persona leerPersona(){
        Persona p=new Persona();
        p.setId(1);
        p.setApellidos("Juan");
        return p;
    } 
    
    @GetMapping("/metodo1")
    public Persona leerPersona1(){
        Persona p=new Persona();
        p.setId(1);
        p.setApellidos("Juan");
        return p;
    }     
    
}

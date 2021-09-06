/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.explicaciones.D20210906.microservicio2.feign;

import com.jorgerubira.explicaciones.D20210902.relaciones.entities.Persona;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "personas", url = "http://localhost:8090")
@RequestMapping("/microservicio1")
public interface PersonasFeign {
    
    @GetMapping
    public Persona leerPersona();
    
    @GetMapping("/metodo1")
    public Persona leerPersona1();    
}

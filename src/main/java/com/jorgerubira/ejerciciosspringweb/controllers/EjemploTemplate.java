/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Ignacio
 */
@Controller
//@requestMapping("/ejemploTemplate")
public class EjemploTemplate {
    @GetMapping()
    public String texto1(){
     return "ejte/vista1";   
    }
    
    @GetMapping
    public String texto2(){
     return "ejte/vista2";   
    }
    
}

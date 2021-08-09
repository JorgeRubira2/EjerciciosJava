
package com.jorgerubira.ejerciciosspringweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ejemplotemplate")
public class EjemploTemplate {
    
    @GetMapping("/texto1")
    public String texto1(){
        return "ejte/vista1";
        
    }
    
     @GetMapping ("/texto2")
    public String texto2(){
        return "ejte/vista2";
        
    }
    
}

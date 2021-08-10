package com.jorgerubira.ejerciciosspringweb.controllers.plantilla;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/ejercicioTemplate")
public class Plantilla {
    
    /******************************************
     *     Ejemplo de Servicio calculadora
     ******************************************/  
    @GetMapping("/texto1")
    public String calc(Model model){
                return "ejte/vista1";
    }
    @GetMapping("/texto2")
    public String calc1(Model model){
                return "ejte/vista2";
    }
    

}

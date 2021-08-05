package com.jorgerubira.explicaciones.D20210804.controllers;

import com.jorgerubira.explicaciones.D20210804.services.Persona;
import com.jorgerubira.explicaciones.D20210804.services.IGestorPersonasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//Ctrl + Espacio -> Intro -> import automatico
//Ctrl + Mayus + i -> import automatico

@Controller
public class PruebasController {
    
    @GetMapping("/dimehola")    //URL que deberemos poner en el navegador
    public String saludar(Model model){  //Recibimos Model para enviar información a la vista.
        String nombre="Pepe";  
        model.addAttribute("persona", nombre);  //Pasar informacion del controlador a la vista.
        return "d20210804/saludo";  //return Nombre de la vista que queremos mostrar. saludo.html 
                          //saludo.html >  resources\templates
    }

    //http://localhost:8080/saludarPersona?nombre=Pepe&edad=25
    @GetMapping("/saludarPersona")
    public String saludarPersona(Model model, String nombre, Integer edad){
        model.addAttribute("nombre", nombre);
        model.addAttribute("edad", edad);  
        return "d20210804/ventanasaludo";  //Debe haber un fichero ventanasaludo.html
    }
    
    @GetMapping("/saludarPersona2")
    public String saludarPersona2(Model model, Persona p){
        model.addAttribute("nombre", p.getNombre());
        model.addAttribute("edad", p.getEdad()); 
        return "d20210804/ventanasaludo";  //Debe haber un fichero ventanasaludo.html
    }    
    
    @GetMapping("/formulario")  //formulario
    public String formuario(){ 
         return "d20210804/formulario";   //formulario.html
    }
    
    @Autowired
    private IGestorPersonasService service;
    
    @PostMapping("/enviarPersona")
    public String enviarPersona(Model model, Persona p){ 
        service.nuevaPersona(p);
        model.addAttribute("nombre", p.getNombre());
        model.addAttribute("edad", p.getEdad()); 
        model.addAttribute("listaPersonas", service.getPersonas());
        return "d20210804/ventanasaludo";  //Debe haber un fichero ventanasaludo.html
    }       

    @GetMapping("/enviarPersona")
    public String enviarPersona2(Model model, Persona p){ 
        service.nuevaPersona(p);
        model.addAttribute("nombre", p.getNombre());
        model.addAttribute("edad", p.getEdad()); 
        model.addAttribute("listaPersonas", service.getPersonas());
        return "d20210804/ventanasaludo";  //Debe haber un fichero ventanasaludo.html
    }       

    
}

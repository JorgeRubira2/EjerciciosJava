/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.explicaciones.D20210809; 

import com.jorgerubira.ejerciciosspringweb.domain.Alumno;
import com.jorgerubira.ejerciciosspringweb.exceptions.OperacionEnListaException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/urlcontrolador")
public class MiControlador {
    
    @Autowired
    private IEjercicio01ListaNombresService services;
    
    public static int sumar(int a, int b){
        return a+b;
    }
    
    public static void main(String[] args) {
        int valor1=2;
        int valor2=3;
        sumar(valor1,valor2);
        
    }
    
    @GetMapping("/leer")
    public String met(Model m){
        m.addAttribute("persona", services.getLista()); 
        m.addAttribute("personaObjeto", List.of(
                new Alumno(1,"Alfredo", "24242424", "Dire1"),
                new Alumno(2,"Alberto", "4444", "Dire2")
        ));
        return "d20210809/vista";
    }
    
    @GetMapping("/leer2")
    public String met2(){
        return "d20210809/vista2";
    }  
    
    @GetMapping("/leer3")
    public String met3(){
        return "d20210809/vista3";
    }       
    
    @PostMapping("/guardar")
    public String met2(Model m, String nombre){
        try {
            services.altaNombre(nombre);
        } catch (OperacionEnListaException ex) {
            Logger.getLogger(MiControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "redirect:leer";
        //return "redirect:/urlcontrolador/leer";
    }

    @PostMapping("/guardar2")
    public RedirectView met3(Model m, String nombre){
        try {
            services.altaNombre(nombre);
        } catch (OperacionEnListaException ex) {
            Logger.getLogger(MiControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new RedirectView("leer");
        //return new RedirectView("/urlcontrolador/leer");
    }    

}

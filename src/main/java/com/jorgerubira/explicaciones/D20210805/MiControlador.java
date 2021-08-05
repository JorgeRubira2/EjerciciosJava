/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.explicaciones.D20210805;

import javax.websocket.server.PathParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/controlador1")
public class MiControlador {
    
    @GetMapping("/saludar")
    public String saludar(Model m){
        m.addAttribute("persona", new Perso("Ana", 24));
        return "d20210805/saludando";
    }
    
    @GetMapping("/persona/{id}")
    public String saludar54(Model m, @PathVariable Long id){
        m.addAttribute("persona", new Perso("a", 4));
        return "d20210805/saludando";
    }    
    
    @GetMapping("/saludar/{nombre}/{edad}")
    public String saludar5(Model m, @PathVariable String nombre, @PathVariable Integer edad){
        m.addAttribute("persona", new Perso(nombre, edad));
        return "d20210805/saludando";
    }    
    
    @PostMapping("/enviarFormulario")
    public String saludar(Model m, Perso p){
        return "d20210805/saludando";
    }    
    
    @PostMapping("/saludar")
    public String saludar3(){
        return "d20210805/saludando";
    }

    @GetMapping("/saludar2")
    public String saludar2(){
        return "d20210805/saludando";
    }

    @GetMapping("/saludar3")
    public String saludar4(){
        return "d20210805/saludando";
    }

}

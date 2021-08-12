/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.explicaciones.D20210811;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/d20210811")
public class CancionController { 
    
    @Autowired
    private CancionRepository repositorio;
    
    @GetMapping("/lista")
    public String leerCanciones(Model m){ 
        m.addAttribute("canciones", repositorio.findByAutorIgnoreCaseContaining("A"));   
        return "d20210811/listado";      
    }
    
    @PostMapping("/enviarDatos")
    public String leerCanciones(Cancion c){ 
        repositorio.save(c);
        return "redirect:lista";
    }
    
    
}

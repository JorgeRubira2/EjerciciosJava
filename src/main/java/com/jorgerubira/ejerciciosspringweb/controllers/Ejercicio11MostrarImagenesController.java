/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/ejercicio11")
public class Ejercicio11MostrarImagenesController {
    
    @GetMapping("/lista")
    public String listaImagenes(Model model){         
        
       //model.addAttribute("lista", lista);         
        return "ej11/mostrarImagenes";
    }
    
}

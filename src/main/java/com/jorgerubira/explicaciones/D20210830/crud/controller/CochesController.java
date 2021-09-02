
package com.jorgerubira.explicaciones.D20210830.crud.controller;

import com.jorgerubira.explicaciones.D20210830.crud.entities.Coche;
import com.jorgerubira.explicaciones.D20210830.crud.repository.CochesRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/coches")
public class CochesController {
    
    @Autowired
    private CochesRepository tablaCoches;
    
    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("coches", tablaCoches.findAll());
        return "d20210830/lista";
    }
    
    @GetMapping("/nuevo")
    public String nuevo(Model model){
        model.addAttribute("coche", new Coche());
        return "d20210830/formulario";
    }
    
    @GetMapping("/editar")
    public String editar(Model model, int id){
        model.addAttribute("coche", tablaCoches.findById(id).get());
        return "d20210830/formulario";
    }
    
    @GetMapping("/borrar")
    public String borrar(Model model, int id){
        tablaCoches.deleteById(id);
        return "redirect:listar";
    }    
    
    
    //@DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaPrueba
    
    @PostMapping("/guardar")
    public String guardar(Model model, Coche coche){
        tablaCoches.save(coche);
        return "redirect:/coches/listar";
        //return "redirect:listar";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.domain.Alumno;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio03GestionAlumnosService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ejercicio3")
public class Ejercicio03GestionAlumnosController {
    
    @Autowired
    private IEjercicio03GestionAlumnosService alumnos;
    
     @GetMapping("/alumnos") 
     public String ListaAlumnos(Model model){        
        model.addAttribute("alumnos", alumnos.getAlumnos());   
        return "ej03/alumnos";
    }
    
    
    @GetMapping("/eliminar")
    public String eliminarAlumno(Model model, long codigo){
        
        alumnos.borrarAlumno(codigo);
        model.addAttribute("alumnos", alumnos.getAlumnos()); 
        return "/ej03/alumnos";
    }
    
    
   @GetMapping("/editar")
   public String editarAlumno(Model model, long codigo){
       
        // public String editarAlumno(Model model){
      
       // Optional<Alumno> alumno = Optional.empty();
        Optional<Alumno>alumno = alumnos.getAlumno(codigo);
        model.addAttribute ("alumno", alumno);
      
        return "/ej03/editar";
    }
    
}

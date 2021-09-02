/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.domain.Alumno;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio03GestionAlumnosService;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author PC
 */
@Controller
@RequestMapping("/ejercicio3")
public class Ejercicio03GestionAlumnosController {
    @Autowired
    private IEjercicio03GestionAlumnosService servicio;
    
    @GetMapping("/mostrar")
    public String mostrar(Model model){
        model.addAttribute("listaAlumnos",servicio.getAlumnos());
        return "/ej03/listaAlumnos";
    }
    
    @PostMapping("/nuevo")
    public String nuevoAlumno(Model model){
        return "/ej03/formNuevo";
    }
    
    @PostMapping("/guardar")
    public String guardarAlumno(Model model, Alumno alumno){
        try{
            model.addAttribute("alumno",alumno);
            servicio.guardarAlumno(alumno);
        }catch(Exception e){
            
        }
        return "/ej03/listaAlumnos";
    }
    
    @PostMapping("/editar")
    public String editar(Model model, Long codigo){
        model.addAttribute("alumno", servicio.getAlumno(codigo));
        return "ej03/formNuevo";
    }
    
    @PostMapping("/borrar")
    public String borrar(Model model, Long codigo){
        servicio.borrarAlumno(codigo);
        model.addAttribute("listaAlumnos", servicio.getAlumnos());
        return "ej03/listaAlumnos";
    }
    
    @GetMapping("/buscar")
    public String buscar(Model model, String nombre){
        model.addAttribute("listaAlumnos",servicio.getAlumnos(nombre));
        return "/ej03/listaAlumnos";
    }
}

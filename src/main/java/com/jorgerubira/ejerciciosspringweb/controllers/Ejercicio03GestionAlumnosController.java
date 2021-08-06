/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.domain.Alumno;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio03GestionAlumnosService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
@RequestMapping("/ejercicio03")
public class Ejercicio03GestionAlumnosController {
    private List<Integer> lista=new ArrayList<>();
    @Autowired
    private IEjercicio03GestionAlumnosService service;
    
    @GetMapping("/alumnos")
    public String inicio(Model model, Integer codigo){
        if(codigo!=null){
            service.borrarAlumno(codigo.longValue());
        }
        model.addAttribute("lista",service.getAlumnos());
        model.addAttribute("number", lista.size()+1);
        return "/ej03/listaAlumnos";
    }
    @PostMapping("/alumnos")
    public String modificacionAlumno(Model model, String nombre, String telefono, String direccion, String eliminar){
        Integer aux=lista.size()+1;
        lista.add(aux);
        Alumno nuevo=new Alumno(aux.longValue(),nombre,telefono,direccion);
        service.guardarAlumno(nuevo);
        model.addAttribute("lista",service.getAlumnos());
        model.addAttribute("number", service.getAlumnos().size()+1);
        return "/ej03/listaAlumnos";
    }
    @GetMapping("/alumnosModificar")
    public String buscador(Model model, Integer codigo){
        Optional<Alumno>aux;
        aux=service.getAlumno(codigo.longValue());
        Alumno resultado=aux.get();
        model.addAttribute("alumno",resultado);
        return "/ej03/modificarAlumno";
    }
    
   
    
}

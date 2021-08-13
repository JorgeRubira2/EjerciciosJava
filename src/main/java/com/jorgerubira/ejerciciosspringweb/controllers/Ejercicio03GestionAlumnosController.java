/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.domain.Alumno;
import com.jorgerubira.ejerciciosspringweb.exceptions.OperacionEnListaException;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio03GestionAlumnosService;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private IEjercicio03GestionAlumnosService gest;
    
    @GetMapping("/listado")
    public String lista(Model model) {
        model.addAttribute("lista", gest.getAlumnos());
        return "ej03/listadoAlumnos";
    }
    
    @GetMapping("/editar")
    public String edicion(Model model) {
        model.addAttribute("lista", gest.getAlumnos());
        return "ej03/nuevoAlumno";
    }
    
    @PostMapping("/guardar")
    public String insertar (Model m, Alumno nuevoAlumno){
        gest.guardarAlumno(nuevoAlumno);
        m.addAttribute("lista", gest.getAlumnos());
        return "ej03/nuevoAlumno";
    }
    
    @PostMapping("/listado")
    public String listado (Model m, String nombre){    
        m.addAttribute("lista", gest.getAlumnos(nombre));
        return "ej03/listadoAlumnos";
    }
        
    @GetMapping("/eliminar")
    public String borrar (Model model, Long codigo){
        gest.borrarAlumno(codigo);//Llamamos al método que hay para dar de baja
        model.addAttribute("lista", gest.getAlumnos());
        return"ej03/listadoAlumnos";
    }
}

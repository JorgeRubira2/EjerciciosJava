/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.domain.Alumno;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio03GestionAlumnosService;
import com.jorgerubira.ejerciciosspringweb.services.Ejercicio03GestionAlumnosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author PC
 * 
 * http://localhost:8080/ejercicio3/alumnos
 * 
 */
@Controller
@RequestMapping("/ejercicio3")
public class Ejercicio03GestionAlumnosController {
    
        /******* SERVICE *******/
    @Autowired
    private Ejercicio03GestionAlumnosService serviceAlumnos;

    @GetMapping("/alumnos")
    public String inicioAlumnos(Model model) {
        model.addAttribute("lista", serviceAlumnos.getAlumnos());
        return "/ej03/listadoAlumnos";
    }
    
    @GetMapping("/crear")
    public String crear() {
        return "/ej03/formNuevoAlumno";
    }
    @PostMapping("/crear")
    public String crearDesdeFormulario(@RequestParam String direccion, @RequestParam String nombre, @RequestParam String telefono, @RequestParam String codigo) {
        Alumno alumno = new Alumno();
        alumno.setDireccion(direccion);
        alumno.setNombre(nombre);
        alumno.setTelefono(telefono);
        alumno.setCodigo( (codigo != null && codigo != "" )? Long.parseLong(codigo) :0 );
        serviceAlumnos.guardarAlumno(alumno);
        return "redirect:/ejercicio03/alumnos";
    }
    
    @GetMapping("/ejercicio03/nuevoAlumno")
    public String ajaxhtml(Model model){
        model.addAttribute("alumno",new Alumno ());
        return "/ejercicio03/alumnos";
    } 
    
            
    @GetMapping("/return")
    public String volver(Model model) {
        model.addAttribute("lista",serviceAlumnos.getAlumnos());
        return "/ej03/listaAlumnos";
    }
}

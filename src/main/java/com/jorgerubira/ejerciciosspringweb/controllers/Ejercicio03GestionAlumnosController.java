/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.domain.Alumno;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio03GestionAlumnosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Mohamad
 */
@Controller
@RequestMapping("/ejercicio3")
public class Ejercicio03GestionAlumnosController {

    @GetMapping("/formulario")
    public String formulario() {
        return "ej03/formularioAlta";
    }

    @Autowired
    private IEjercicio03GestionAlumnosService service;

    @GetMapping("/listaAlumnos")
    public String lista(Model model) {
        model.addAttribute("listaAlumnos", service.getAlumnos());
        return "ej03/regAlumnos";

    }

    @PostMapping("/altaAlumno")
    public String altaAlumno(Model model, Alumno alumno) {
        service.guardarAlumno(alumno);
        model.addAttribute("listaAlumnos", service.getAlumnos());
        return "ej03/regAlumnos";
    }

    @GetMapping("/buscarAlumnoCodigo")
    public String buscarAlumno(Model model, long codigo) {
        model.addAttribute("codigo", service.getAlumno(codigo).get().getCodigo());
        model.addAttribute("nombre", service.getAlumno(codigo).get().getNombre());
        model.addAttribute("telefono", service.getAlumno(codigo).get().getTelefono());
        model.addAttribute("direccion", service.getAlumno(codigo).get().getDireccion());
        return "ej03/formularioEdita";
    }

    @PostMapping("/buscarAlumno")
    public String buscarAlumnoPorNombre(Model model, String nombre) {
        model.addAttribute("listaAlumnos", service.getAlumnos(nombre));
        return "ej03/regAlumnos";
    }

    @GetMapping("/eliminar")
    public String eliminarAlumno(Model model, Long codigo) {
        service.borrarAlumno(codigo);
        model.addAttribute("listaAlumnos", service.getAlumnos());
        return "ej03/regAlumnos";
    }
}

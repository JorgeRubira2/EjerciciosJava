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

    @Autowired
    private IEjercicio03GestionAlumnosService service;

    @GetMapping("/alumnos")
    public String inicio(Model model, Integer codigo) {
        if (codigo != null) {
            service.borrarAlumno(codigo.longValue());
        }
        model.addAttribute("lista", service.getAlumnos());
        model.addAttribute("number", (int) (Math.random() * 99999999));//número aleatorio para nuevo alumno
        return "/ej03/listaAlumnos";
    }

    @PostMapping("/alumnos")
    public String modificacionAlumno(Model model, Integer codigo, String nombre, String telefono, String direccion) {
        long a = codigo.longValue();
        Alumno nuevo = new Alumno(a, nombre, telefono, direccion);
        service.guardarAlumno(nuevo);
        model.addAttribute("lista", service.getAlumnos());
        model.addAttribute("number", (int) (Math.random() * 99999999));//número aleatorio para nuevo alumno
        return "/ej03/listaAlumnos";
    }

    @GetMapping("/alumnosBuscados")
    public String buscador(Model model, String buscar) {
        List<Alumno> aux = new ArrayList<>();
        aux = service.getAlumnos(buscar);
        model.addAttribute("lista", aux);
        model.addAttribute("number", (int) (Math.random() * 99999999));//número aleatorio para nuevo alumno
        return "/ej03/listaAlumnos";
    }

    @GetMapping("/alumnosModificar")
    public String modificador(Model model, Integer codigo) {
        Optional<Alumno> aux;
        long a = codigo.longValue();
        aux = service.getAlumno(a);
        Alumno resultado = aux.get();
        model.addAttribute("alumno", resultado);
        return "/ej03/modificarAlumno";
    }

}

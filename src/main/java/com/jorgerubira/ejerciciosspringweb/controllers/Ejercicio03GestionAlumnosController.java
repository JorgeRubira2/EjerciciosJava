/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.domain.Alumno;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio03GestionAlumnosService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    private IEjercicio03GestionAlumnosService alumnos;

    @GetMapping("/crud")
    public String crud(Model model) {
        model.addAttribute("alumnos", alumnos.getAlumnos());
        return ("ej03/crud");
    }

    @GetMapping("/eliminar")
    public String eliminarAlumno(Model model, long codigo) {
        alumnos.borrarAlumno(codigo);
        model.addAttribute("alumnos", alumnos.getAlumnos());
        return ("ej03/crud");
    }

    @GetMapping("/crud/nuevo")
    public String vistaFormulario() {

        return ("ej03/formularionuevoalumno");
    }

    @PostMapping("/addAlumno")
    public String nuevoAlumno(Model model, long codigo, String nombre, String telefono, String direccion) {

        Alumno a = new Alumno(codigo, nombre, telefono, direccion);
        alumnos.guardarAlumno(a);
        model.addAttribute("alumnos", alumnos.getAlumnos());

        return ("ej03/crud");
    }

    @GetMapping("/editar/{id}")
    public String editarAlumno(Model model, @PathVariable Long id) {

        model.addAttribute("alumno", alumnos.getAlumno(id).get());
        alumnos.borrarAlumno(id);
        return ("ej03/formularioeditaralumno");
    }

    @GetMapping("/buscar")
    public String buscarAlumno(Model model, String alumno) {

        if(alumno.isBlank()){
            return ("ej03/crud");
        }
        
        boolean codigo = Character.isDigit(alumno.charAt(0)) && Character.isDigit(alumno.charAt(alumno.length()-1));
        
        if (codigo && alumnos.getAlumno(Long.valueOf(alumno)).isPresent()) {
            
            model.addAttribute("alumnos", alumnos.getAlumno(Long.valueOf(alumno)).get());
            
        } else {
             List<Alumno> busqueda = alumnos.getAlumnos(alumno).stream().filter((t) -> {
                return t.getNombre().equals(alumno);
            }).collect(Collectors.toList());

            model.addAttribute("alumnos", busqueda.isEmpty()?List.of():busqueda);

        }

        return ("ej03/crud");
    }
}

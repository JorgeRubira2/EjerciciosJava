package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.domain.Alumno;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio03GestionAlumnosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ejercicio3")
public class Ejercicio03GestionAlumnosController {

    // TODO
    @Autowired
    private IEjercicio03GestionAlumnosService list;

    @GetMapping("")
    public String list(Model model) {

        model.addAttribute("lista", list.getAlumnos());

        return "ej03/listaAlumnos";
    }

    @GetMapping("/formulario")
    public String formulario(Model model, Long codigo) {
        model.addAttribute("codigoControlador", list.getAlumno(codigo));

        return "ej03/formulario";
    }

    @GetMapping("/formularioNuevo")
    public String formularioNuevo(Model model, Alumno alumno) {
        model.addAttribute("codigoControlador", alumno);
        return "ej03/formulario";
    }

    @PostMapping("/busqueda")
    public String busquedaNombre(Model model, String nombre) {

        if (nombre.matches("[+-]?\\d*(\\.\\d+)?")) {
            model.addAttribute("lista", list.getAlumno(Long.parseLong(nombre)).get());
        } else {
            model.addAttribute("lista", list.getAlumnos(nombre));
        }

        return "ej03/listaAlumnos";
    }

    @PostMapping("/editarAlumno")
    public String editarAlumno(Model model, Long codigo, String nombre, String telefono, String direccion) {

        list.guardarAlumno(new Alumno(codigo, nombre, telefono, direccion));

        return "redirect:/ejercicio3/";
    }

    @GetMapping("/borrar/{codigo}")
    public String borrarUsuario(Model model, @PathVariable Long codigo) {

        list.borrarAlumno(codigo);

        model.addAttribute("lista", list.getAlumnos());

        return "ej03/listaAlumnos";
    }

}

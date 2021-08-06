/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.domain.Alumno;
import com.jorgerubira.ejerciciosspringweb.services.Ejercicio03GestionAlumnosService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author PC
 */
@Controller
@RequestMapping("/ejercicio03")
public class Ejercicio03GestionAlumnosController {

    @Autowired
    private Ejercicio03GestionAlumnosService serviceGestionAlumnos;

    @GetMapping("/alumnos")
    public String inicio(Model model) {
        model.addAttribute("lista", serviceGestionAlumnos.getAlumnos());
        return "/ej03/listaAlumnos";
    }

    @PostMapping("/search")
    public String buscar(Model model, @RequestParam("codigoNombre") String codigoNombre) {
        if (codigoNombre != null) {
            try {
                model.addAttribute("lista", serviceGestionAlumnos.getAlumno(Long.parseLong(codigoNombre)).isPresent()
                                ?serviceGestionAlumnos.getAlumno(Long.parseLong(codigoNombre)).get()
                                :null);
            } catch (NumberFormatException e) {
                model.addAttribute("lista", serviceGestionAlumnos.getAlumnos(codigoNombre));
            }
        }
        return "/ej03/listaAlumnos";
    }

    @GetMapping("/create")
    public String crear() {
        return "/ej03/formNuevoAlumno";
    }
    
    @PostMapping("/create")
    public String crearDesdeFormulario(@RequestParam String direccion, @RequestParam String nombre, @RequestParam String telefono, @RequestParam String codigo) {
        Alumno alumno = new Alumno();
        alumno.setDireccion(direccion);
        alumno.setNombre(nombre);
        alumno.setTelefono(telefono);
        alumno.setCodigo( (codigo != null && codigo != "" )? Long.parseLong(codigo) :0 );
        serviceGestionAlumnos.guardarAlumno(alumno);
        return "redirect:/ejercicio03/alumnos";
    }

    @GetMapping("/delete/{codigo}")
    public String borrar(Model model,@PathVariable Long codigo) {
        serviceGestionAlumnos.borrarAlumno(codigo);
        model.addAttribute("lista",serviceGestionAlumnos.getAlumnos());
        model.addAttribute("mensaje", "Alumno eliminado");
        return "/ej03/listaAlumnos";
    }

    @GetMapping("/edit/{codigo}")
    public String editar(Model model,@PathVariable Long codigo) {
        Optional<Alumno> alumno = serviceGestionAlumnos.getAlumno(codigo);
        if (alumno.isEmpty()) {
            alumno = Optional.of(new Alumno());
        }
        model.addAttribute("direccion",alumno.get().getDireccion());
        model.addAttribute("nombre",alumno.get().getNombre() );
        model.addAttribute("telefono",alumno.get().getTelefono() );
        model.addAttribute("codigo",alumno.get().getCodigo());
        return "/ej03/formNuevoAlumno";
    }
    
    
    @GetMapping("/return")
    public String volver(Model model) {
        model.addAttribute("lista",serviceGestionAlumnos.getAlumnos());
        return "/ej03/listaAlumnos";
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.domain.Alumno;
import com.jorgerubira.ejerciciosspringweb.exceptions.OperacionEnListaException;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio03GestionAlumnosService;
import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ejercicio03")
public class Ejercicio03GestionAlumnosController {

    @Autowired
    private IEjercicio03GestionAlumnosService service;

    //ME DEVUELVE LA VISTA CON EL ARRAYLIST
    @GetMapping("/devolverlista") //URL A LLAMAR
    public String lista(Model model) {

        model.addAttribute("listaPersonas", service.getAlumnos());

        return "ej03/listaAlumnos";
    }

    //METODO PARA IR A NUEVO ALUMNO
    @PostMapping("/nuevousuario") //URL A LLAMAR
    public String nuevousuario(Model model) {

        return "ej03/nuevoAlumno";
    }

//MOSTRAR HTML NUEVO ALUMNO
    @GetMapping("/nuevousuario") //URL A LLAMAR
    public String nuevousuario2(Model model) {

        return "ej03/nuevoAlumno";
    }

    //DA DE ALTA UN ALUMNO
    @PostMapping("/alta") //URL A LLAMAR
    public String altaAlumno(Model model, Alumno alumno) {

        try {
            model.addAttribute("alumno", alumno);
            service.guardarAlumno(alumno);
            model.addAttribute("correcto", "Se ha añadido correctamente");
        } catch (Exception e) {
            model.addAttribute("error", "Ha ocurrido un error al insertar");
        }

        return "ej03/nuevoAlumno";
    }

    @GetMapping("/borrar") //URL A LLAMAR
    public String borrarAlumno(Model model, Long codigo) {
        model.addAttribute("codigo?", codigo);
        service.borrarAlumno(codigo);
        model.addAttribute("listaPersonas", service.getAlumnos());

        return "ej03/listaAlumnos";
    }

    @GetMapping("/modificar") //URL A LLAMAR
    public String editarAlumno(Model model, Long codigo) {
        model.addAttribute("codigo?", codigo);
        service.getAlumno(codigo);
        model.addAttribute("alumno",service.getAlumno(codigo));

        return "ej03/modificarAlumno";
    }

}

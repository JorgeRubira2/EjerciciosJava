/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jorgerubira.ejerciciosspringweb.domain.Alumno;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio03GestionAlumnosService;

@Controller
@RequestMapping("/ejercicio3")
public class Ejercicio03GestionAlumnosController {
    
    @Autowired
    private IEjercicio03GestionAlumnosService gestor;
    
    @GetMapping("/listaAlumnos")
    public String getPaginaLista(Model model){
        model.addAttribute("buscador", "");
        model.addAttribute("listaAlumnos", gestor.getAlumnos());
        return "ej03/listaAlumnos";
    }
    
    @GetMapping("/insertarAlumno")
    public String getPaginaInsertar(Model model){
        model.addAttribute("nombre", "");
        model.addAttribute("telefono", "");
        model.addAttribute("direccion", "");
        return "ej03/insertarAlumno";
    }
    
    @PostMapping("/addAlumno")
    public String addAlumno(Model model, Alumno a){
    	gestor.guardarAlumno(a);
        getPaginaLista(model);//redirige a la lista
        return "ej03/listaAlumnos";
    }
    
    @GetMapping("/actualizarAlumno/{codigo}")
    public String getPaginaActualizar(Model model,@PathVariable("codigo") Long codigo){
        model.addAttribute("codigo",  gestor.getAlumno(codigo).get().getCodigo());
        model.addAttribute("nombre", gestor.getAlumno(codigo).get().getNombre());
        model.addAttribute("telefono",  gestor.getAlumno(codigo).get().getTelefono());
        model.addAttribute("direccion",  gestor.getAlumno(codigo).get().getDireccion());
        return "ej03/actualizarAlumno";
    }
    
    @PostMapping("/updateAlumno")
    public String updateAlumno(Model model, Alumno a){
    	gestor.guardarAlumno(a);
        getPaginaLista(model);//redirige a la lista
        return "ej03/listaAlumnos";
    }
    
    @GetMapping("/deleteAlumno/{codigo}")
    public String deleteAlumno(Model model,@PathVariable("codigo") Long codigo){
        model.addAttribute("codigo", codigo);
    	gestor.borrarAlumno(codigo);
        getPaginaLista(model);//redirige a la lista
        return "ej03/listaAlumnos";
    }
}

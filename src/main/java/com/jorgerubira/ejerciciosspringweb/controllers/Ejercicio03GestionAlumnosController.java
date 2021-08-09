package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.domain.Alumno;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio01ListaNombresService;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio03GestionAlumnosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ejercicio3")
public class Ejercicio03GestionAlumnosController {

    @Autowired
    private IEjercicio03GestionAlumnosService list;

    @GetMapping("")
    public String list(Model model) {
        
        model.addAttribute("lista", list.getAlumnos());
        
        return "ej03/listaAlumnos";
    }

    @PostMapping("/busquedaCodigo")
    public String busquedaCodigo(Model model, Long codigo) {
        
        model.addAttribute("lista", list.getAlumno(codigo));
        model.addAttribute("cuadrobusqueda", " ");
        
        return "ej03/listaAlumnos";
    }

    @PostMapping("/busquedaNombre")
    public String busquedaNombre(Model model, String buscar) {
        
        model.addAttribute("lista", list.getAlumnos(buscar));
        model.addAttribute("cuadrobusqueda", " ");
        
        return "ej03/listaAlumnos";
    }

    @PostMapping("/nuevoUsuario")
    public String nuevoUsuario(Model model, Long codigo, String nombre, String telefono, String direccion) {

        Alumno alumno = new Alumno();
        
        alumno.setCodigo(codigo);
        alumno.setNombre(nombre);
        alumno.setTelefono(telefono);
        alumno.setDireccion(direccion);
        list.guardarAlumno(alumno);

        model.addAttribute("cuadrobusqueda", " ");
        model.addAttribute("lista", list.getAlumnos());

        return "ej03/listaAlumnos";
    }
    
    @PostMapping("/borrarUsuario")
    public String borrarUsuario(Model model, Long codigo) {

        list.borrarAlumno(codigo);

        model.addAttribute("cuadrobusqueda", " ");
        model.addAttribute("lista", list.getAlumnos());

        return "ej03/listaAlumnos";
    }
}

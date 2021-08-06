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

@Controller
@RequestMapping("/ej03")
public class Ejercicio03GestionAlumnosController {
    @Autowired
    private IEjercicio03GestionAlumnosService listaAlumnos;
    
    @GetMapping("/listaAlumnos")
    public String lista(Model m){
        m.addAttribute("persona", new Alumno());
        m.addAttribute("listaAlumnos", listaAlumnos.getAlumnos());
        return "ej03/listaAlumnos";
    }
    
    @PostMapping("/listaAlumnos")
    public String listaInserta(Model m,String codigo, String nombre, String telefono, String direccion, String accion){
        System.out.println(codigo);
        if(Long.valueOf(codigo) != 0){
            listaAlumnos.guardarAlumno(new Alumno(Long.valueOf(codigo),nombre,telefono,direccion));
        }else{
            long codigonuevo = (int)(Math.random()*99999999);
            listaAlumnos.guardarAlumno(new Alumno(codigonuevo,nombre,telefono,direccion));
        }
        m.addAttribute("persona", new Alumno());
        m.addAttribute("listaAlumnos", listaAlumnos.getAlumnos());
        return "ej03/listaAlumnos";
    }
    
    @GetMapping("/listaAlumnos/borrar")  
    public String borrar(Model m, String codigo){ 
        m.addAttribute("persona", new Alumno());
        listaAlumnos.borrarAlumno(Long.valueOf(codigo));
        m.addAttribute("listaAlumnos", listaAlumnos.getAlumnos());
        return "ej03/listaAlumnos"; 
    }
    
    @GetMapping("/listaAlumnos/editar")  
    public String editar(Model m, String codigo){ 
         m.addAttribute("persona", listaAlumnos.getAlumno(Long.valueOf(codigo)).get());
         m.addAttribute("listaAlumnos", listaAlumnos.getAlumnos());
         return "ej03/listaAlumnos"; 
    }
  
}

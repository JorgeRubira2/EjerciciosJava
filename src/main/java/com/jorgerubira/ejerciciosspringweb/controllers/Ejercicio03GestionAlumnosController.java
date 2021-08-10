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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jorgerubira.ejerciciosspringweb.domain.Alumno;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio03GestionAlumnosService;

/**
 *
 * @author PC
 */
@Controller
@RequestMapping("/ejercicio3")
public class Ejercicio03GestionAlumnosController {

	@Autowired
	private IEjercicio03GestionAlumnosService service;

	@GetMapping("/gestionAlumno")
	public String lista(Model model) {
		model.addAttribute("lista", service.getAlumnos());
		return "ej03/gestionAlumno";
	}
	 @PostMapping("/gestionAlumno")
	    public String nuevo(Model model, Long codigo, String nombre, String telefono, String direccion) {
	        Alumno alumno = new Alumno();
	        alumno.setCodigo(codigo);
	        alumno.setNombre(nombre);
	        alumno.setTelefono(telefono);
	        alumno.setDireccion(direccion);
	        service.guardarAlumno(alumno);
	        model.addAttribute("lista", service.getAlumnos());

	        return "ej03/listaAlumno";
	    }

	    @GetMapping("/gestionAlumno/eliminar")
	    public String eliminarAlumnos(Model model, Long codigo) {

	        service.borrarAlumno(codigo);
	        model.addAttribute("lista", service.getAlumnos());

	        return "ej03/listaAlumno";
	    }
//	@PostMapping("/alta")
//	public String altaAlumno(Model model, Alumno alumno) {
//		
//		service.guardarAlumno(alumno);
//		model.addAttribute("lista", alumno);
//		return "ej03/Alta";
//	}
//
//	@GetMapping("/borrar")
//	public String borrarAlumno(Model model, Long codigo) {
//		service.borrarAlumno(codigo);
//		model.addAttribute("lista", service.getAlumnos());
//		return "ej03/gestionAlumno";
//	}
//
//	@GetMapping("/modificar")
//	public String modificarAlumno(Model model, Long codigo) {
//		model.addAttribute("alumno", service.getAlumno(codigo));
//		return "";
//	}
}
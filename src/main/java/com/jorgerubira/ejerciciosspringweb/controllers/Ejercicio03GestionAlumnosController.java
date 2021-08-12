/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
		Alumno alumnos = new Alumno();
		alumnos.setCodigo(codigo);
		alumnos.setNombre(nombre);
		alumnos.setTelefono(telefono);
		alumnos.setDireccion(direccion);
		service.guardarAlumno(alumnos);
		model.addAttribute("lista", service.getAlumnos());

		return "ej03/gestionAlumno";
	}

	@GetMapping("/gestionAlumno/eliminar")
	public String eliminarAlumnos(Model model, Long codigo) {
		service.borrarAlumno(codigo);
		model.addAttribute("lista", service.getAlumnos());

		return "ej03/gestionAlumno";
	}

	@PostMapping("/buscarAlumno")
	public String buscarAlumnos(Model model, String nombre) {
		service.getAlumnos(nombre);
		model.addAttribute("lista", service.getAlumnos(nombre));
		return "ej03/gestionAlumno";
	}

	@GetMapping("/gestionAlumno/modificar")
	@ResponseBody
	public Alumno editarAlumnos(Long codigo) {

		return service.getAlumno(codigo).get();
	}

}
package com.jorgerubira.ejerciciosspringweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jorgerubira.ejerciciosspringweb.entities.Imagen;
import com.jorgerubira.ejerciciosspringweb.repositories.ImagenesRepository;

import lombok.Setter;

@Controller
@RequestMapping("/ejercicio9")
public class Ejercicio09Imagenes {


	@Setter   //Crear el set de repositorio para el test de unidad
	@Autowired(required = false)    //Con required = false no es obligatorio que esté el repository
	private ImagenesRepository imgRepository;
	
	@GetMapping
	public String lista(Model m){
		m.addAttribute("imagenes", imgRepository.findAll());
		return "ej09/lista";
	}
	
	
//para acceder al formulario vacio
//	@GetMapping("/formulario")
//	public String read(Model m){
//		m.addAttribute("imagen", new Imagen());
//		return "ej09/formulario";
//	}
	
	//Estoy probando para acceder al formulario (crear y editar) con un solo metodo
	@GetMapping("/formulario/{id}")
	public String read(Model m, @PathVariable Integer id){
		if(id == null) {
			m.addAttribute("imagen", new Imagen());//para crear
		}else
			m.addAttribute("imagen", imgRepository.findById(id));//para editar
		return "ej09/formulario";
	}
	
	@PostMapping("/save")
	public String save(Model m, Imagen img){
		imgRepository.save(img);
		return "redirect:/ejercicio9";
	}   
}

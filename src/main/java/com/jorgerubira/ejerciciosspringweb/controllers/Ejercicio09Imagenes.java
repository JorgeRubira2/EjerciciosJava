package com.jorgerubira.ejerciciosspringweb.controllers;

import java.util.Date;

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
	
	
	@GetMapping("/formulario")
	public String read(Model m){
		m.addAttribute("imagen", new Imagen());
		return "ej09/formulario";
	}
	
	@GetMapping("{id}")
	public String read(Model m, @PathVariable Integer id){
		m.addAttribute("imagen", imgRepository.findById(id));
		return "ej09/formulario";
	}
	
	@PostMapping("/save")
	public String save(Model m, Imagen img){
		img.setFechaHoraFichero(new Date());
		imgRepository.save(img);
		return "redirect:/ejercicio9";
	}

	@GetMapping("/delete/{id}")
	public String delete(Model m, @PathVariable Integer id){
		imgRepository.deleteById(id);
		return "redirect:/ejercicio9";
	}    

}

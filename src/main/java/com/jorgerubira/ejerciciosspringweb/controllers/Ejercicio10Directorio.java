package com.jorgerubira.ejerciciosspringweb.controllers;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ejercicio10")
public class Ejercicio10Directorio {

	@GetMapping
	public String lista(Model m, String ruta){
		if(ruta == null) {
			ruta = "C:\\Users\\acer\\Documents\\Adrián\\Curso Hiberus\\EjerciciosJava\\src\\main\\resources";
		}
		File file = new File(ruta);
		File []ficherosInternos=file.listFiles();
		for (File ficheroInterno : ficherosInternos) {
			m.addAttribute("directorios", ficheroInterno);
		}
		return "ej10/lista";
	}
}

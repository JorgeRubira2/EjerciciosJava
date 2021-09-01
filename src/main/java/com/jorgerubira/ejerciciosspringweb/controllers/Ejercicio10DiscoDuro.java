package com.jorgerubira.ejerciciosspringweb.controllers;

import java.io.File;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jorgerubira.ejerciciosjava.Ejercicio10Ficheros;
import com.jorgerubira.ejerciciosspringweb.domain.Fichero;

@Controller
public class Ejercicio10DiscoDuro {
	
	@GetMapping("ej10/vista")
	
	public String vista(Model model , String ruta) {
		if(ruta==null) {
			ruta="C:\\";
		}
		 
		File file= new File(ruta);
		ArrayList<Fichero> F = new ArrayList<>();
		
			File[] ficherosInternos=file.listFiles();
			for (File ficheroInterno : ficherosInternos) {
				try {
					F.add(new Fichero(ficheroInterno.getName(),ficheroInterno.isDirectory(),ficheroInterno.getAbsolutePath()));
					
				} catch (Exception e) {
					model.addAttribute("error","Error en la ruta ruta");
				}
				
			}
			model.addAttribute("ruta",F);
			model.addAttribute("Ruta", ficherosInternos)
		
		return "ej10/vista";
	}

}

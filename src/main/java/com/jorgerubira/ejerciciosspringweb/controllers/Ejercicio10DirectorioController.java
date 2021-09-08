package com.jorgerubira.ejerciciosspringweb.controllers;

import java.io.File;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jorgerubira.ejerciciosspringweb.domain.Fichero;

@Controller
@RequestMapping("/ejercicio10")
public class Ejercicio10DirectorioController {

    @Value("${carpetas.recursos.hiberus}")
    private String rutaRecursos;
	
	@GetMapping("/directorios")
	public String lista(Model m, String ruta){
		if(ruta == null) {
			ruta = "C:\\";
		}
		File file = new File(ruta);

		ArrayList<Fichero> listaFicheros = new ArrayList<>();
		if (file.isDirectory()){
			File []ficherosInternos=file.listFiles();
			for (File ficheroInterno : ficherosInternos) {
				try{
					listaFicheros.add(new Fichero(ficheroInterno.getName(), ficheroInterno.isDirectory(), ficheroInterno.getAbsolutePath()));

				}catch(Exception e){
					e.printStackTrace();
				}
			}
			m.addAttribute("directorios", listaFicheros);
			if(ruta!=null)
				m.addAttribute("pariente", file.getParent());//boton de volver
		}
		return "ej10/lista";
	}
 
}

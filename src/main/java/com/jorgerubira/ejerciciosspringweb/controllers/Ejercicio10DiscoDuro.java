package com.jorgerubira.ejerciciosspringweb.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.MediaType;
import com.jorgerubira.ejerciciosjava.Ejercicio10Ficheros;
import com.jorgerubira.ejerciciosspringweb.domain.Fichero;

@Controller
public class Ejercicio10DiscoDuro {
	
	@GetMapping("ej10/vista")
	
	public String vista(Model model , String ruta) {
		 
		 if (ruta == null){
	            ruta = "C:\\";
	        }
		 
		File file= new File(ruta);
		if(ruta !="C:\\") {
			model.addAttribute("parent", file.getParent());
		}
		ArrayList<Fichero> F = new ArrayList<>();
		if(file.isDirectory()) {
			File[] ficherosInternos=file.listFiles();
			for (File ficheroInterno : ficherosInternos) {
				try {
					F.add(new Fichero(ficheroInterno.getName(),ficheroInterno.isDirectory(),ficheroInterno.getAbsolutePath()));
					
				} catch (Exception e) {
					model.addAttribute("error","Error en la ruta ruta");
				}
				
			}
			model.addAttribute("ruta",F);
		
		}
		return "ej10/vista";
	}
	@GetMapping("ej10/descargar")
    public ResponseEntity<Resource> descarga(String ruta) {
        File archivo = new File(ruta);
        HttpHeaders cabeceras = new HttpHeaders();
        cabeceras.add("Content-Disposition", "attachment; filename=" + archivo.getName());
        cabeceras.add("Cache-Control", "no-cache, no-store, must-revalidate");
        cabeceras.add("Pragma", "no-cache");
        cabeceras.add("Expires", "0");

        try {
            return ResponseEntity.ok()
                    .headers(cabeceras)
                    .contentLength((new File(ruta)).length())
                    .contentType(MediaType.parseMediaType("application/octet-stream")) //Codigo MIME
                    .body(new InputStreamResource(new FileInputStream(ruta)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }


}

package com.jorgerubira.ejerciciosspringweb.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jorgerubira.ejerciciosspringweb.domain.Fichero;

@Controller
@RequestMapping("/ejercicio10")
public class Ejercicio10Directorio {

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
	
	@GetMapping("/descarga")
	public ResponseEntity<Resource>  mostrarFormulario(int imagen){
		String ruta=rutaRecursos + "\\d20210901\\ejemplo1\\imagen" + imagen +".jpg";

		HttpHeaders cabeceras=new HttpHeaders();
		cabeceras.add("Content-Disposition", "attachment; filename=imagen.jpg");
		cabeceras.add("Cache-Control", "no-cache, no-store, must-revalidate");
		cabeceras.add("Pragma", "no-cache");
		cabeceras.add("Expires", "0");

		try{
			return ResponseEntity.ok()
					.headers(cabeceras)
					.contentLength((new File(ruta)).length())
					.contentType(MediaType.parseMediaType( "application/octet-stream" ))  //Codigo MIME
					.body(new InputStreamResource(new FileInputStream( ruta )) );
		}catch(FileNotFoundException e){
			e.printStackTrace();
			return null;
		}
        
    }  
}

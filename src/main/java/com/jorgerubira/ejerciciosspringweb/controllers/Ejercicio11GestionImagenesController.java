package com.jorgerubira.ejerciciosspringweb.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.jorgerubira.ejerciciosspringweb.entities.Imagen;
import com.jorgerubira.ejerciciosspringweb.repositories.ImagenRepository;

@Controller
@RequestMapping("/ejercicio11")
public class Ejercicio11GestionImagenesController {
	
	@Autowired(required = false) //no es obligatorio el repository
	private ImagenRepository imagenRepository ;
	
	@Value("${carpetas.recursos.hiberus}")
	private String rutaRecursos;
	
	@GetMapping("/vista")
    public String vista(Model m) {

        m.addAttribute("imagenes", imagenRepository.findAll());

        return "ej11/vista";

    }
	@PostMapping("/subir")
	public String Subir(Model model, MultipartFile fichero, Imagen imagen,String descripcion) {
		String nombre = UUID.randomUUID().toString();
		String ruta = rutaRecursos + "\\ejercicio11\\imagenes\\" + nombre;
		
		File file = new File(ruta);
		file.getParentFile().mkdirs();
		
		try {
			Files.copy(fichero.getInputStream(),file.toPath(),StandardCopyOption.REPLACE_EXISTING);
			
			imagen.setRuta(nombre); 
            imagen.setNombre(fichero.getOriginalFilename());
            imagen.setDescripcion(descripcion);
            imagenRepository.save(imagen);
            
		} catch (IOException e) {
            e.printStackTrace();
            
        }
		return "redirect:vista";
		
	}
	@GetMapping("/descargar")
    public ResponseEntity<Resource> descarga(String nombre) {
		String ruta = rutaRecursos + "\\ejericio11\\imagenes\\" + nombre;
        
        HttpHeaders cabeceras = new HttpHeaders();
        cabeceras.add("Content-Disposition", "attachment; filename=" + nombre);
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
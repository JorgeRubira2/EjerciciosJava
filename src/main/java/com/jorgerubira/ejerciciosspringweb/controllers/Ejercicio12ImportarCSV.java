package com.jorgerubira.ejerciciosspringweb.controllers;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.jorgerubira.ejerciciosspringweb.entities.Universidad;
import com.jorgerubira.ejerciciosspringweb.repositories.UniversidadRepository;

@Controller
@RequestMapping("/ejercicio12")
public class Ejercicio12ImportarCSV {
	 private Date convertirStringADate(String fecha) {
		try {
			SimpleDateFormat fechaFormato = new SimpleDateFormat("dd/mm/yyyy");
			return (Date) fechaFormato.parse(fecha);
		} catch (Exception e) {
			return null;
		}
		
		
		
	}
	 
	@Autowired(required = false) 
	private UniversidadRepository univRepo;
	
	@Value("${carpetas.recursos.hiberus}")
	private String rutaRecursos;
	
	@GetMapping("/vista")
    public String vista(Model model, String mensaje){
		if(mensaje!=null) {
			
		
		if(mensaje.contains("exito")){
			model.addAttribute("sucess", mensaje);
			
		}else if(mensaje.contains("error")) {
			model.addAttribute("error", mensaje);
			}
		}
        return "/ej12/vista";
    } 
	@PostMapping("/subir")
	public String subir (Model model,MultipartFile archivo) {
		
		String ruta = rutaRecursos +"\\ejercicio12\\Csv"+ archivo.getOriginalFilename();
		String mensaje = null;
		File file = new File(ruta);
		file.getParentFile().mkdirs();
		try {
			Files.copy(archivo.getInputStream(),file.toPath(), StandardCopyOption.REPLACE_EXISTING);
			Files.lines(file.toPath()).skip(1)
			.map(x->x.split(";"))
			.map(x->new Universidad(
				null,
				Integer.parseInt(x[0]),
				x[1],
				x[2],
				x[3],
				x[4],
				x[5],
				Integer.parseInt(x[6]),
				Integer.parseInt(x[7]),
				Integer.parseInt(x[8]),
				Double.parseDouble(x[9]),
				convertirStringADate(x[10])))
			.forEach(x->univRepo.save(x));
			mensaje = "Archivo subido con exito";

		} catch (Exception e) {
			e.printStackTrace();
			mensaje ="Error en la subida";
		} 
		return "redirect:/ejercicio12/vista?mensaje="+mensaje;
			
		
		
		
	}

}

package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.entities.Imagen;
import com.jorgerubira.ejerciciosspringweb.repositories.GestionImagenesRepository;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/ej11")
public class Ejercicio11GestionImagenes {
    
    @Autowired(required = false)
    private GestionImagenesRepository repositorio;
    
    @Value("${carpetas.recursos.hiberus}")
    private String rutaRecursos;

    @GetMapping("/ver")
    public String mostrarFormulario(Model m, String success){
        m.addAttribute("success", success);
        return "ej11/formulario";
    }
    
    @PostMapping("/subir")
    public String subir(Model m, MultipartFile fichero, Imagen imagen){ //, HttpServletResponse response){
        
        if (fichero.getOriginalFilename().toLowerCase().endsWith(".jpg")==false){
            m.addAttribute("error", "Formato incorrecto");
            return "ej11/formulario";
        }
        
        String nombre = UUID.randomUUID().toString()+".jpg";
        String ruta=rutaRecursos + "\\ej11\\imagenes\\" + nombre;
        
        imagen.setAleatorio(nombre);           
        imagen.setNombre(fichero.getOriginalFilename());
       
        repositorio.save(imagen);
        File f=new File(ruta);
        f.getParentFile().mkdirs();
        
        try{
            Files.copy(fichero.getInputStream(), f.toPath(), StandardCopyOption.REPLACE_EXISTING);    
            return "redirect:verImagenes?success=Fichero subido";
        }catch(IOException e){
            e.printStackTrace();
            m.addAttribute("error", "Error inesperado");
        }
        return "ej11/formulario";
    }
    
    @GetMapping("/verImagenes")
    public String mostrarImagen(Model m){
        m.addAttribute("imagenes", repositorio.findAll());
        return "ej11/verImagen";
    }    

    @GetMapping("/descarga")
    @ResponseBody
    public ResponseEntity<Resource>  mostrarFormulario(String nombre){
        String ruta=rutaRecursos + "\\ej11\\imagenes\\" + nombre;
        
        HttpHeaders cabeceras=new HttpHeaders();
        cabeceras.add("Content-Disposition", "attachment; filename=" + UUID.randomUUID().toString());
        cabeceras.add("Cache-Control", "no-cache, no-store, must-revalidate");
        cabeceras.add("Pragma", "no-cache");
        cabeceras.add("Expires", "0");

        try{
            return ResponseEntity.ok()
                                 .headers(cabeceras)
                                 .contentLength((new File(ruta)).length())
                                 .contentType(MediaType.parseMediaType( "application/octet-stream" ))  //Codigo MIME
                                 .body(new InputStreamResource(new FileInputStream( ruta )) );
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }    

    @PostMapping("/filtrarImagen")
    public String filtrarImagen(Model model, String descripcion){
        model.addAttribute("imagenes", repositorio.findByDescripcionContaining(descripcion));
        return "ej11/verImagen";
    }  
    
    @GetMapping("/borrarImagen")
    public String borrarImagen(String aleatorio){
        Imagen img = repositorio.findByAleatorio(aleatorio);
        repositorio.delete(img); //lo elimina de la base de datos
        
        String ruta=rutaRecursos + "\\ej11\\imagenes\\" + aleatorio;
        try {
            Files.delete(Path.of(ruta)); //lo elimina de la carpeta
            return "redirect:verImagenes?success=Fichero borrado";
        } catch (Exception e) {
             e.printStackTrace();
        }
        return "ej11/verImagen";
    } 
}

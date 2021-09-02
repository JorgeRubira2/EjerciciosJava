
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.entities.Imagen;
import com.jorgerubira.ejerciciosspringweb.repositories.ImagenesRepository;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
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

@Controller
@RequestMapping("/ejercicio11")
public class Ejercicio11GestionImagenes {
    
    @Autowired
    private ImagenesRepository repoImg;
    
    @Value("${carpetas.recursos.hiberus}")
    private String rutaRecursos; 
    
    @GetMapping("/gestor")
    public String gestor(Model m){
        m.addAttribute("imagenes", repoImg.findAll());
        return "ej11/gestionimagenes";
    }
    
    @PostMapping("/subir")
    public String subir(Model m, MultipartFile fichero, String descripcion){
        
        String nombreOriginal = fichero.getOriginalFilename();
        String nombreRandom = UUID.randomUUID().toString()+".jpg";
        nombreRandom = nombreRandom.replace("-","");
        
        String ruta = rutaRecursos + "\\d20210901\\ejemplo1\\" + nombreRandom;
        File f = new File(ruta);
        f.getParentFile().mkdirs();
        try{
            Files.copy(fichero.getInputStream(), f.toPath(), StandardCopyOption.REPLACE_EXISTING);    
        }catch(IOException e){
            e.printStackTrace();
            m.addAttribute("error", "Error inesperado");
        }    
        repoImg.save(new Imagen(null, descripcion, ruta, nombreOriginal));
        
        return "redirect:gestor";
    }
    
    @GetMapping("/descargar")
    public ResponseEntity<Resource> mostrarImg(String ruta){
        
        //String ruta = rutaRecursos + "\\d20210901\\ejemplo1\\";
        
        HttpHeaders cabeceras=new HttpHeaders();
        cabeceras.add("Content-Disposition", "attachment;");
        cabeceras.add("Cache-Control", "no-cache, no-store, must-revalidate");
        cabeceras.add("Pragma", "no-cache");
        cabeceras.add("Expires", "0");
        
        try{
            return ResponseEntity.ok()
                                 .headers(cabeceras)
                                 .contentLength((new File(ruta)).length())
                                 .contentType(MediaType.parseMediaType( "application/octet-stream" ))
                                 .body(new InputStreamResource(new FileInputStream( ruta )) );
        }catch(FileNotFoundException e){
            e.printStackTrace();
            return null;
        }
    }    
    
    @GetMapping("/borrar")
    public String borrar(int id){
        repoImg.deleteById(id);
        return "redirect:gestor";
    }
    
    @PostMapping("/filtrar")
    public String filtrar(Model model, String descripcion){
        List<Imagen> img = repoImg.findByDescripcionContains(descripcion);
        if (!img.isEmpty()) {
            model.addAttribute("imagenes",  img);
        } else {
            model.addAttribute("error",  "No hay ninguna imagen con esa descripción");
        }
        return "ej11/gestionimagenes";
    }
}

package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.entities.Imagen;
import com.jorgerubira.ejerciciosspringweb.repositories.ImagenRepository;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
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

/**
 *
 * @author Mohamad
 */
@Controller
@RequestMapping("/ejercicio11")
public class Ejercicio11GestionImagenes {
    
    @Autowired
    private ImagenRepository repImg; 

    @Value("${carpetas.recursos.hiberus}")
    private String rutaRecursos;
    
      @GetMapping("/galeria")
    public String mostrarFormulario(Model m, String success){
        m.addAttribute("success", success);
        return "ej11/galeria";
    }
   

    @PostMapping("/subir")
    public String subir(Model m, MultipartFile fichero,String descripcion) {
        
        if (fichero.getOriginalFilename().toLowerCase().endsWith(".jpg") == false) {
            m.addAttribute("error", "Formato incorrecto");
            return "ej11/galeria";
        }
        String aleatorio= UUID.randomUUID().toString();
        Imagen img=new Imagen(null,descripcion,aleatorio);
        repImg.save(img);      
        String ruta = rutaRecursos + "\\ejercicio11\\" + aleatorio ;
        File f = new File(ruta);
        f.getParentFile().mkdirs();
        try {
            Files.copy(fichero.getInputStream(), f.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return "redirect:verImagenes";
        } catch (IOException e) {
            e.printStackTrace();
            m.addAttribute("error", "Error inesperado");
        }
        return "redirect:galeria";
    }
    
     @GetMapping("/verImagenes")
   
    public String mostrarImagen(Model model){
        model.addAttribute("imagenes",repImg.findAll());
        return "ej11/verImagenes";
    }
    
    @GetMapping("/descarga")
    public ResponseEntity<Resource>  mostrarFormulario(String aleatorio){
        String ruta=rutaRecursos + "\\ejercicio11\\" + aleatorio;
        
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
    
    
    @GetMapping("/eliminar")
    public String eliminar(Model model, Integer Id) {
        repImg.deleteById(Id);
        
        return "redirect:verImagenes";
    }
    
      @GetMapping("/abrir")
    public String abrir(Model model, Integer Id) {
        Imagen img = repImg.findById(Id).get();
        model.addAttribute("imagen",img);
        return "ej11/verImagen";
    }
    
    @PostMapping("/buscar")
    public String buscar(Model model, String descripcion) {
        List<Imagen> lista=repImg.findByDescripcionContaining(descripcion);
        model.addAttribute("imagenes", lista);
        return "ej11/verImagenes";
        
    }


 
}

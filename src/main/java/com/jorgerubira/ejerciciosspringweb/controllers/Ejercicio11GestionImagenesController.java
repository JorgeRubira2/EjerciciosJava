package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.entities.Imagen;
import com.jorgerubira.ejerciciosspringweb.repositories.ImagenRepository;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.UUID;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/ejercicio11")
public class Ejercicio11GestionImagenesController {
    
    @Setter   //Crear el set de repositorio para el test de unidad
    @Autowired(required = false)    //Con required = false no es obligatorio que esté el repository
    private ImagenRepository repoImg;
    
    @Value("${carpetas.recursos.hiberus}")
    private String rutaRecursos;
    
    @GetMapping
    public String inicio(Model m, String success){
        if(repoImg.findAll().isEmpty()){
            m.addAttribute("imagenes", new Imagen());
        }else{
            m.addAttribute("imagenes", repoImg.findAll());
        }
        m.addAttribute("success", success);
        return "/ej11/vista";
    }
    
    @PostMapping("/subir")
    public String subir(Model m, MultipartFile fichero, String descripcion){ //, HttpServletResponse response){
        String nombre = fichero.getOriginalFilename();
        String codigo = UUID.randomUUID().toString();
        String ext = nombre.substring(nombre.lastIndexOf("."), nombre.length());
        String ruta=rutaRecursos + "\\ej11\\" + codigo + ext;
        
        File f=new File(ruta);
        f.getParentFile().mkdirs();

        try{
            Files.copy(fichero.getInputStream(), f.toPath(), StandardCopyOption.REPLACE_EXISTING);
            Imagen img = new Imagen();
            img.setCodigo(codigo);img.setDescripcion(descripcion);img.setNombre(nombre);img.setRuta(ruta);
            repoImg.save(img);
            return "redirect:/ejercicio11?success=Fichero subido";
        }catch(IOException e){
            e.printStackTrace();
            m.addAttribute("error", "Error inesperado");
        }
        return "/ej11/vista";
    }
}

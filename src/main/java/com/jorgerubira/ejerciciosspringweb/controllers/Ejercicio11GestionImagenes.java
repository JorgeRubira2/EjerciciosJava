/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.entities.Imagen;
import com.jorgerubira.ejerciciosspringweb.repositories.ImagenRepository;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import lombok.Setter;
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
 * @author karly
 */
@Controller
@RequestMapping("/ejercicio11")
public class Ejercicio11GestionImagenes {
    
    @GetMapping("/imagenes") 
    public String listar(Model model, String ruta){
        return "ej11/index";
    }    
    
    @Setter  
    @Autowired(required = false)   
    private ImagenRepository repoImg;
    
    @Value("${carpetas.recursos.hiberus}")
    private String rutaRecursos;
    
    @GetMapping("/imagenes")
    public String inicio(Model m, String success, String borrado, String filtrar){
        if(repoImg.findAll().isEmpty()){
            m.addAttribute("imagenes", null);
        }else if (filtrar!=null){
            List<Imagen> filtradas = repoImg.findAll().stream().filter(x->x.getDescripcion().contains(filtrar)).collect(Collectors.toList());
            m.addAttribute("imagenes",filtradas);
        }else{
            m.addAttribute("imagenes", repoImg.findAll());
        }
        m.addAttribute("success", success);
        m.addAttribute("borrado", borrado);
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

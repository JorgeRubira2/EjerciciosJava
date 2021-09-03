package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.entities.Imagen9;
import com.jorgerubira.ejerciciosspringweb.repositories.CategoriasRepository;
import com.jorgerubira.ejerciciosspringweb.repositories.Imagen9Repository;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ejercicio09")
public class Ejercicio09GestorImagenesController {
    
    @Setter   //Crear el set de repositorio para el test de unidad
    @Autowired(required = false)    //Con required = false no es obligatorio que esté el repository
    private Imagen9Repository repoImg;
    
    @Setter   //Crear el set de repositorio para el test de unidad
    @Autowired(required = false)    //Con required = false no es obligatorio que esté el repository
    private CategoriasRepository repoCat;
    
    @Value("${carpetas.recursos.hiberus}")
    private String rutaRecursos;
    
    @GetMapping
    public String inicio(Model m, String success, String error, String filtrar){
        if(repoImg.findAll().isEmpty()){
            m.addAttribute("imagenes", null);
        }else if (filtrar!=null){
            //List<Imagen> filtradas = repoImg.findAll().stream().filter(x->x.getDescripcion().contains(filtrar)).collect(Collectors.toList());
            //m.addAttribute("imagenes",filtradas);
        }else{
            m.addAttribute("imagenes", repoImg.findAll());
        }
        if(repoCat.findAll().isEmpty()){
            m.addAttribute("categorias", null);
        }else{
            m.addAttribute("categorias",repoCat.findAll());
        }
        m.addAttribute("success", success);
        return "/ej09/vista";
    }
    
    @PostMapping("/subir")
    public String subir(Model m, Imagen9 img){ //, HttpServletResponse response){
        try {
            URL url = new URL(img.getUrl());
            
            m.addAttribute("success", "Imagen subida con exito");
        } catch (MalformedURLException ex) {
            m.addAttribute("error", "Enlace no valido");
        }
    
        
        return "/ej09/vista" ;
    }
}

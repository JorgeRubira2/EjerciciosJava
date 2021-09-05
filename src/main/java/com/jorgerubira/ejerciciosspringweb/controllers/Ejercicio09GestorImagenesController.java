package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.entities.CategoriaEntity;
import com.jorgerubira.ejerciciosspringweb.entities.Imagen;
import com.jorgerubira.ejerciciosspringweb.entities.Imagen9;
import com.jorgerubira.ejerciciosspringweb.repositories.CategoriasRepository;
import com.jorgerubira.ejerciciosspringweb.repositories.Imagen9Repository;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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
    public String inicio(Model m, String msg, String filtrar){
        if(repoImg.findAll().isEmpty()){
            m.addAttribute("imagenes", null);
        }else if (filtrar!=null){
            List<Imagen9> filtradas = repoImg.findAll().stream().filter(x->x.getDescripcion().contains(filtrar)).collect(Collectors.toList());
            m.addAttribute("imagenes",filtradas);
        }else{
            m.addAttribute("imagenes", repoImg.findAll());
        }
        if(repoCat.findAll().isEmpty()){
            m.addAttribute("categorias", null);
        }else{
            m.addAttribute("categorias",repoCat.findAll());
        }
        if (msg!=null){
            if (msg.contains("valido")){
                m.addAttribute("error",msg);
            }else if(msg.contains("exito")) {
                m.addAttribute("success",msg);
            }
        }
        return "/ej09/vista";
    }
    
    @PostMapping("/subir")
    public String subir(Model m, Imagen9 img){ //, HttpServletResponse response){
        String msg = null;
        try {
            URL url = new URL(img.getUrl());
            img.setFechaHoraFichero(new Date());
            repoImg.save(img);
            msg = "Imagen subida con exito";
        } catch (MalformedURLException ex) {
            msg = "Enlace no valido";
        }
    
        
        return "redirect:/ejercicio09?msg="+msg ;
    }
    
    @PostMapping("/categoria")
    public String subir(Model m, CategoriaEntity cat){ //, HttpServletResponse response){
        String msg = null;
        if (cat!=null){
            repoCat.save(cat);
            msg = "Categoria registrada con exito";
        }else{
            msg = "Campo no valido";
        }

        return "redirect:/ejercicio09?msg="+msg ;
    }
    
    @GetMapping("/borrar")
    public String borrar(Model m, Integer codigo){
        Optional<Imagen9> borrar = repoImg.findById((long)codigo);
        String del = "";
        if (borrar.isPresent()){
            repoImg.delete(borrar.get());
            del = "Imagen borrada con exito";
        }
        return "redirect:/ejercicio09?msg="+del;
    }
}

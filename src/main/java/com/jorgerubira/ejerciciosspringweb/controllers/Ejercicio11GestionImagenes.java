
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.entities.Imagen;
import com.jorgerubira.ejerciciosspringweb.repositories.ImagenRepository;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Isabel
 */
@Controller
@RequestMapping("/ejercicio11")
public class Ejercicio11GestionImagenes {
    
    @Autowired
    private ImagenRepository imagenRepo;
    
    @Value("${carpetas.recursos.hiberus}")
    private String rutaRecursos;
    
    
    @GetMapping("/ver")
    public String verFormulario(Model model, String success){
        model.addAttribute("success", success);
        return "/ej11/formulario";
    }
    
    //SEGUIR AQUÍ......................................
    @PostMapping("/subir")
    public String subirFichero(Model model, MultipartFile fichero){
        String nombre = UUID.randomUUID().toString();
        String ruta = rutaRecursos + "\\ejercicio11\\" + nombre;
        
        return "ej11/formulario";
    }
    
    
    
 

    
}

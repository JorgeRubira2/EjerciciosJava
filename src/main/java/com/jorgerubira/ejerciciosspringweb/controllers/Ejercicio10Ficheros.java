package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.domain.Fichero;
import java.io.File;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Ejercicio10Ficheros{
    
    @GetMapping("/ej10/lista")
    public String lista(Model model, String ruta) {
        if (ruta==null){
            ruta="C:\\";
        }
        File file = new File (ruta);
        ArrayList<Fichero> contenido = new ArrayList<>();
        if (file.isDirectory()){
            File []ficherosInternos=file.listFiles();
            for (File ficheroInterno : ficherosInternos) {
                try{
                    contenido.add(new Fichero(ficheroInterno.getName(), ficheroInterno.isDirectory(), ficheroInterno.getAbsolutePath(), ficheroInterno.getAbsolutePath()));
                    
                }catch(Exception e){
                    
                }
            }
            model.addAttribute("contenido", contenido);
        }
        return "ej10/vista";
    }
}
    
    
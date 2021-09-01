
package com.jorgerubira.ejerciciosspringweb.controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/ejercicio10")

public class Ejercicio10MostrarDiscoDuroController {
    

     
    @GetMapping("/lista")
    public String listaArchivos(Model model, String ruta){
        List<File> lista = new ArrayList<>();  
    
        File f;
        if (ruta == null){
           ruta= "C:\\";
        } 
        
       
        f =new File(ruta);  
        if(ruta!=null){
             model.addAttribute("ruta", f.getParent());
        }
               
        File []ficherosInternos = f.listFiles();
        for (File ficheroInterno : ficherosInternos) {
                //if (ficheroInterno.isDirectory()){
            lista.add(ficheroInterno);
                 
         }      
        
        model.addAttribute("lista", lista);         
        
        
        return "ej10/mostrarDisco";
    }

    
}

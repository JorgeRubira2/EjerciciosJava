package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.domain.Fichero;
import java.io.File;
import java.util.ArrayList;
import javax.websocket.server.PathParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class Ejercicio10DiscoDuro {
    
    @GetMapping("/ejercicio10/archivos")
    public String archivos(Model model, String path){
        String ruta;
        if(path==null){
            ruta ="C://";
        }else{
            ruta=path;
        }
        File f=new File(ruta);
        ArrayList<Fichero> nombres = new ArrayList<>();
        if (f.isDirectory()){
            File []ficherosInternos=f.listFiles();
            for (File ficheroInterno : ficherosInternos) {
                try{
                    nombres.add(new Fichero(ficheroInterno.getName(),ficheroInterno.isDirectory(),ficheroInterno.getAbsolutePath()));    
                }catch(Exception e){
                    
                }
            }
            model.addAttribute("Nombres",nombres);
        }
        return "ej10/index";
    }
}

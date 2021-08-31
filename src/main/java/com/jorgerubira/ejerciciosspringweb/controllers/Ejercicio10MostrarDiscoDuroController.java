package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.domain.Fichero;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import static java.lang.Math.log;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/ejercicio10")
public class Ejercicio10MostrarDiscoDuroController {
    
    @GetMapping
    public String inicio(Model m, @RequestParam(required = false) String ruta){
        String anterior = null;  
        if (ruta == null){
            ruta = "C:";
        }else if (!"C:".equalsIgnoreCase(ruta)){
            anterior = ruta.substring(0, ruta.lastIndexOf('/'));
        }
        m.addAttribute("rutaActual",ruta);
        m.addAttribute("anterior", anterior);
        File f= new File(ruta);
        ArrayList<Fichero> ficheros= new ArrayList<>();

        File []ficherosInternos=f.listFiles();
            for (File ficheroInterno : ficherosInternos) {
                try{
                    ficheros.add(new Fichero(ficheroInterno.getName(),ficheroInterno.isDirectory()));    
                }catch(Exception e){
                    m.addAttribute("error","Error de ruta");
                }
            }
        m.addAttribute("rutas",ficheros);

        return "/ej10/mostrar";
    }
    @RequestMapping(value="files", method=RequestMethod.GET)
    @ResponseBody
    public FileSystemResource downloadFile(@RequestParam String fichero) {
        return new FileSystemResource(new File(fichero));
    }
}

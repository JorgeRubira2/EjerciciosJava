package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.domain.Fichero;
import java.io.File;
import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    @RequestMapping(value="files", method=RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public FileSystemResource downloadFile(HttpServletResponse response, @RequestParam String fichero, @RequestParam String nombre) {
        response.setHeader("Content-Disposition", "attachment; filename=" + nombre);
        return new FileSystemResource(new File(fichero));
    }
}

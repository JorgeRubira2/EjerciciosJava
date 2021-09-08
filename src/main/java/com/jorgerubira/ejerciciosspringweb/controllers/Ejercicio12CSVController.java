package com.jorgerubira.ejerciciosspringweb.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.jorgerubira.ejerciciosspringweb.entities.Plaza;
import com.jorgerubira.ejerciciosspringweb.repositories.UniversidadRepository;

import lombok.Setter;

@Controller
@RequestMapping("/ejercicio12")
public class Ejercicio12CSVController {

    @Value("${carpetas.recursos.hiberus}")
    private String rutaBase;
	
    @Setter 
    @Autowired(required = false)    //Con required = false no es obligatorio que esté el repository
    private UniversidadRepository repoPlazas;
    
    @GetMapping
    public String inicio(Model m,String msg){
        if(msg!=null){
            if (msg.toLowerCase().contains("error")){
                m.addAttribute("error",msg);
            }else if (msg.toLowerCase().contains("exito")){
                m.addAttribute("success",msg);
            }
        }
        
        return "/ej12/vista";
    }
    
    @PostMapping("/subir")
    public String subir(Model m, MultipartFile fichero){ //, HttpServletResponse response){
     String rutaEjercicio = rutaBase +"\\ejercicio12\\";
        
        String ruta = rutaEjercicio + fichero.getOriginalFilename();
        File f = new  File(ruta);  
        f.getParentFile().mkdirs();
        try {
            Files.copy(fichero.getInputStream(), f.toPath(), StandardCopyOption.REPLACE_EXISTING);   
            Stream<String> lineas= Files.lines(Path.of(ruta));
            lineas.skip(1)
                  .parallel()
                  .filter(x-> x != null)
                  .filter(x -> "".equals(x) == false)
                  .map(x -> x.split(";"))
                  .forEach(x -> {
                                    try {
                                       repoPlazas.save(new Plaza(null,
                                                Integer.parseInt(x[0]),
                                                x[1],
                                                x[2],
                                                x[3],
                                                x[4],
                                                x[5],
                                                Integer.parseInt(x[6]),
                                                Integer.parseInt(x[7]),
                                                Integer.parseInt(x[8]),
                                                Double.parseDouble(x[9]),
                                                new SimpleDateFormat("dd/MM/yyyy").parse(x[10])));
                                    } catch (Exception ex) {
                                        m.addAttribute("error", "fallo en formateo de fechas " + x[10]);
                                        Logger.getLogger(Ejercicio12CSVController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                });

            
            m.addAttribute("mensaje", "fichero correctamente insertado");
        } catch (IOException ex) {
            m.addAttribute("error", "fallo en inserciones");
            Logger.getLogger(Ejercicio12CSVController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            f.delete();
        }
        return "redirect:/ejercicio12";
    }

}

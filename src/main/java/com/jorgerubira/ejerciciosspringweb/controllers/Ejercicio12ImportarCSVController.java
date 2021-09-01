/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.entities.DatoUniversidad;
import com.jorgerubira.ejerciciosspringweb.repositories.DatoUniversidadRepository;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import static org.apache.http.client.methods.RequestBuilder.delete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author janus
 */
@Controller
@RequestMapping("/ejercicio12")
public class Ejercicio12ImportarCSVController {
    @Autowired
    private DatoUniversidadRepository repoDatoUniversidad;
    
    // @Value("${carpetas.recursos.hiberus}")
    private String rutaBase="C:\\zzCursoHiberus";  

    private String rutaEjercicio = rutaBase +"\\ejercicio12\\";
    
    @GetMapping("/tratarDatos")
    public String tratar(){
        return "ej12/formularioSubida";
    }
    
    
    @PostMapping("/tratarDatos")
    public String tratamientoCSV(Model model, MultipartFile fichero){
        
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
                                        repoDatoUniversidad.save(new DatoUniversidad(null,
                                                Integer.parseInt(x[0]),
                                                x[1],
                                                x[2],
                                                x[3],
                                                x[4],
                                                x[5],
                                                Integer.parseInt(x[6]),
                                                Integer.parseInt(x[7]),
                                                Integer.parseInt(x[8]),
                                                Float.parseFloat(x[9]),
                                                new SimpleDateFormat("dd/MM/yyyy").parse(x[10])));
                                    } catch (ParseException ex) {
                                        model.addAttribute("error", "fallo en formateo de fechas " + x[10]);
                                        Logger.getLogger(Ejercicio12ImportarCSVController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                });

            
            model.addAttribute("mensaje", "fichero correctamente insertado");
        } catch (IOException ex) {
            model.addAttribute("error", "fallo en inserciones");
            Logger.getLogger(Ejercicio12ImportarCSVController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            f.delete();
        }
        return "ej12/formularioSubida";
    }
}

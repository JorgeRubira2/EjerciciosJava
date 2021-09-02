/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosjava.Ejercicio10Ficheros;
import com.jorgerubira.ejerciciosspringweb.entities.CarrerasUniversidad;
import com.jorgerubira.ejerciciosspringweb.interfaces.CarreraUniversidadRepository;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/ejercicio12")
public class Ejercicio12ImportarCSVController {

    @Autowired
    private CarreraUniversidadRepository repCarrUni;

    @Value("${ejercicio12.archivos.subidos}")
    private String rutaRecursos;

    @GetMapping("/formulario")
    public String formulario() {
        return "ej12/formulario";
    }

    @GetMapping("/ver")
    public String mostrarFormulario(Model model, String success) {
        model.addAttribute("success", success);
        return "ej12/formulario";
    }

    @PostMapping("/subirCSV")
    public String subirCSV(Model model, MultipartFile fichero) {

        if (fichero.getOriginalFilename().toLowerCase().endsWith(".csv") == false) {
            model.addAttribute("error", "Formato incorrecto, solo puededs subir ficheros .csv");
            return "ejercicio12/formulario";
        }
        //UUID.randomUUID().toString();
        String ruta = rutaRecursos + "\\" + fichero.getOriginalFilename();
        File f = new File(ruta);
        f.getParentFile().mkdirs();
        try {
            Files.copy(fichero.getInputStream(), f.toPath(), StandardCopyOption.REPLACE_EXISTING);
            leerYCargarDatos(ruta);
            return "redirect:ver?success=Fichero subido";
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("error", "Error inesperado");
        }

        return "ej12/formulario";
    }

    public void leerYCargarDatos(String ruta) {
        //List<CarrerasUniversidad> lista = new ArrayList<>();
        try {
            Files.readAllLines(Paths.get(ruta), Charset.defaultCharset()).stream().skip(1).forEach((t) -> {
                if (!t.isBlank()) {
                    //lista.add(new Persona(t.trim().split(";")[0], t.trim().split(";")[1]));
                    String[] datos = t.split(";");
                    
                    
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate fecha = LocalDate.parse(datos[10], formato);
                    
                    repCarrUni.save(new CarrerasUniversidad(
                                                            null, Integer.parseInt(datos[0]), datos[1], datos[2], datos[3], datos[4],
                                                            datos[5], Integer.parseInt(datos[6]), Integer.parseInt(datos[7]), Integer.parseInt(datos[8]),
                                                            Double.parseDouble(datos[9]), fecha));
                    
                    /*
                    lista.add(new CarrerasUniversidad(
                            null, Integer.parseInt(datos[0]), datos[1], datos[2], datos[3], datos[4],
                            datos[5], Integer.parseInt(datos[6]), Integer.parseInt(datos[7]), Integer.parseInt(datos[8]), Double.parseDouble(datos[9]), fecha));
                    */
                }
                
                //repCarrUni.saveAll(lista);
                
            });

        } catch (IOException ex) {
            Logger.getLogger(Ejercicio10Ficheros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

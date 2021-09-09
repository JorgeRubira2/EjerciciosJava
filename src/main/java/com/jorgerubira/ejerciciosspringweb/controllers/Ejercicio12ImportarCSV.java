package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.entities.CSV;
import com.jorgerubira.ejerciciosspringweb.repositories.CSVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;

import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * TODO: Ejercicio terminado
 * 
 * Se muestra un formulario para la subida del archivo
 * 
 * El archivo solo puede ser .csv
 * 
 * Si se produce un error, salta un mensaje de error
 * 
 * Cuando se completa la subida, salta un mensaje de que se completó
 * correctamente
 * 
 * Si no se selecciona un archivo, no se habilita el botón de subir
 */

@Controller
@RequestMapping("/ejercicio12")
public class Ejercicio12ImportarCSV {

    @Value("${carpetas.recursos.hiberus}")
    private String rutaRecursos;

    @Autowired
    private CSVRepository repositorioCSV;

    // Con este método nos vamos al formulario de subida
    @GetMapping("")
    public String verFormulario(Model model, String success) {
        model.addAttribute("success", success);
        return "/ej12/formCSV";
    }

    // Con este método subimos el fichero y lo inyectamos en la BBDD
    @PostMapping("/subirCSV")
    public String subir(Model model, MultipartFile fichero) {
        String ruta = rutaRecursos + "\\ejercicio12\\" + fichero.getOriginalFilename();
        File f = new File(ruta);
        f.getParentFile().mkdirs();
        try {
            Files.copy(fichero.getInputStream(), f.toPath(), StandardCopyOption.REPLACE_EXISTING);
            Files.readAllLines(f.toPath()).stream().skip(1).map(x -> x.split(";")).map(x -> {
                try {
                    return new CSV(null, Integer.valueOf(x[0]), x[1], x[2], x[3], x[4], x[5], Integer.valueOf(x[6]),
                            Integer.valueOf(x[7]), Integer.valueOf(x[8]), Double.valueOf(x[9]),
                            new SimpleDateFormat("dd/MM/yyyy").parse(x[10]));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return null;
            }).forEach(p -> repositorioCSV.save(p));
            Files.deleteIfExists(f.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("error", "Error en la subida");
            return "/ej12/formCSV";
        } catch (NumberFormatException e) {
            e.printStackTrace();
            model.addAttribute("error", "Error en la subida");
            return "/ej12/formCSV";
        }
        return "redirect:?success=Subida completada";
    }
}
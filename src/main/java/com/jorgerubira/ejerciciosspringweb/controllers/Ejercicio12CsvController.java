package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.entities.Plaza;
import com.jorgerubira.ejerciciosspringweb.repositories.PlazaRepository;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
@RequestMapping("/universidad")

public class Ejercicio12CsvController {

    @Autowired(required = false)//Con required = false no es obligatorio que esté el repository 

    private PlazaRepository repoPlaza;

    @Value("${carpetas.recursos.hiberus}")
    private String rutaRecursos;

    @GetMapping
    public String mostrarTodo(Model m) {

        return "ej12/formulario";

    }

    @PostMapping("/subir")
    public String subir(Model m, MultipartFile fichero) {

        if (fichero.getOriginalFilename().toLowerCase().endsWith(".csv") == false) {
            m.addAttribute("error", "Formato incorrecto");
            return "ej12/formulario";
        }
        String ruta = rutaRecursos + "\\d20210909\\ejemplo1\\" + fichero.getOriginalFilename();
        File f = new File(ruta);
        f.getParentFile().mkdirs();

        try {
            Files.copy(fichero.getInputStream(), f.toPath(), StandardCopyOption.REPLACE_EXISTING);
            Files.lines(f.toPath())
                    .skip(1)
                    .map(x -> {
                        String[] campos = x.split(";");

                        Plaza plaza = new Plaza(
                                null,
                                Integer.parseInt(campos[0]),
                                campos[1],
                                campos[2],
                                campos[3],
                                campos[4],
                                campos[5],
                                Integer.parseInt(campos[6]),
                                Integer.parseInt(campos[7]),
                                Integer.parseInt(campos[8]),
                                Double.parseDouble(campos[9]),
                                fecha(campos[10])
                        );
                        return plaza;
                    }).forEach(x -> repoPlaza.save(x));
        } catch (IOException e) {
            e.printStackTrace();

        }

        return "ej12/formulario";
    }

    private Date fecha(String fecha) {
        SimpleDateFormat nuevoFormato = new SimpleDateFormat("dd/MM/yyyy");

        Date fechaNueva = null;

        try {

            fechaNueva = nuevoFormato.parse(fecha);

        } catch (ParseException ex) {

            Logger.getLogger(Ejercicio12CsvController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return fechaNueva;

    }

}

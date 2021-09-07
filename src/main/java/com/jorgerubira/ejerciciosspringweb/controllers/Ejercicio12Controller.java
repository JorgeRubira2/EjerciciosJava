package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosjava.Ejercicio10Ficheros;
import com.jorgerubira.ejerciciosjava.pojo.Persona;
import com.jorgerubira.ejerciciosspringweb.domain.Universitario;
import com.jorgerubira.ejerciciosspringweb.repositories.ImagenRepository;
import com.jorgerubira.ejerciciosspringweb.repositories.UniversitarioRepository;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ejercicio12")
public class Ejercicio12Controller {

    String rutaBase = "D:\\NetBeansProjects\\EjerciciosJava\\src\\main\\java\\com\\jorgerubira\\resources\\";

    @Autowired
    private UniversitarioRepository universitarioRepository;

    @GetMapping("/pagina")
    public String o() {
        return "ej11/vista.html";
    }

    @GetMapping("/leer")
    @RequestMapping
    public void leerCSV() {
        String fichero = "DatosUniversidad.csv";

        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

            List<Universitario> list = Files.lines(Paths.get(rutaBase + fichero))
                    .skip(1)
                    .map(x -> new Universitario(1, (Integer.parseInt(x.split(";")[0])), x.split(";")[1],
                    x.split(";")[2], x.split(";")[3], x.split(";")[4], x.split(";")[5], Integer.parseInt(x.split(";")[6]),
                    Integer.parseInt(x.split(";")[7]), Integer.parseInt(x.split(";")[8]), Double.parseDouble(x.split(";")[9]),
                    new Date(2020 - 05 - 02))/*
                    format.parse(x.split(";")[10]))*/)
                    .collect(Collectors.toList());

            list.stream().forEach(x -> universitarioRepository.save(x));

        } catch (Exception ex) {
            Logger.getLogger(Ejercicio10Ficheros.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

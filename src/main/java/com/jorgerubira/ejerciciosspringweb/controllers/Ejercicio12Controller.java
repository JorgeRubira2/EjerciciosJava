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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ejercicio12")
public class Ejercicio12Controller {

    String rutaBase = "D:\\NetBeansProjects\\EjerciciosJava\\src\\main\\java\\com\\jorgerubira\\resources\\";

    @Autowired
    private UniversitarioRepository universitarioRepository;

    @GetMapping("/pagina")
    public String o() {
        return "ej11/vista.html";
    }

    public Date parsearFecha(String date) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = null;
        try {
            fecha = format.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(Ejercicio12Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        return fecha;

    }

    @GetMapping("/leer")
    public List<Universitario> leerCSV() {
        String fichero = "DatosUniversidad.csv";
        List<Universitario> list = null;
        try {

            list = Files.lines(Paths.get(rutaBase + fichero))
                    .skip(1)
                    .map(x
                            -> new Universitario((Integer.parseInt(x.split(";")[0])), x.split(";")[1],
                            x.split(";")[2], x.split(";")[3], x.split(";")[4], x.split(";")[5], Integer.parseInt(x.split(";")[6]),
                            Integer.parseInt(x.split(";")[7]), Integer.parseInt(x.split(";")[8]), Double.parseDouble(x.split(";")[9]),
                            parsearFecha(x.split(";")[10])))
                    .collect(Collectors.toList());

            list.stream().forEach(x -> universitarioRepository.save(x));

        } catch (Exception ex) {
            Logger.getLogger(Ejercicio10Ficheros.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}

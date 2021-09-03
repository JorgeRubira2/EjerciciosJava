package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.entities.Plaza;
import com.jorgerubira.ejerciciosspringweb.repositories.PlazaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/ej12")
public class Ejercicio12ImportarCSV {

    @Value("${carpetas.recursos.hiberus}")
    private String rutaRecursos;

    @Autowired
    private PlazaRepository repositorio;

    @GetMapping("/formulario")
    public String verFormulario(){
        return "/ej12/formulario";
    }

    @PostMapping("/insertar")
    @ResponseBody
    public String subir(Model m, MultipartFile fichero){
        String ruta = rutaRecursos + "\\ej12\\" + fichero.getOriginalFilename();
        File f = new File(ruta);
        f.getParentFile().mkdirs();
        try {
            Files.copy(fichero.getInputStream(), f.toPath(), StandardCopyOption.REPLACE_EXISTING);
            Files.readAllLines(f.toPath())
                    .stream()
                    .skip(1)
                    .map(x->x.split(";"))
                    .map(x-> new Plaza(null, Integer.valueOf(x[0]), x[1], x[2],x[3],x[4],x[5],
                            Integer.valueOf(x[6]),Integer.valueOf(x[7]),Integer.valueOf(x[8]),Double.valueOf(x[9]),parsearFecha(x[10])))
                    .forEach(p-> repositorio.save(p));
            Files.deleteIfExists(f.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return "Fallo";
        }
        return "OK";
    }

    @PostMapping("/insertar2")
    @ResponseBody
    public String subir2(Model m, MultipartFile fichero){
        List<List<String>> records = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(fichero.getInputStream()));
            String linea;
            while((linea=br.readLine())!=null){
                String[] values = linea.split(";");
                records.add(Arrays.asList(values));
            }
            records.stream()
                    .skip(1)
                    .map(x-> new Plaza(null, Integer.valueOf(x.get(0)), x.get(1), x.get(2), x.get(3), x.get(4), x.get(5),
                            Integer.valueOf(x.get(6)),Integer.valueOf(x.get(7)),Integer.valueOf(x.get(8)),Double.valueOf(x.get(9)), parsearFecha(x.get(10))))
                    .forEach(p-> repositorio.save(p));
        } catch (IOException e) {
            e.printStackTrace();
            return "Fallo";
        }
        return "OK";
    }

    private Date parsearFecha(String fecha){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaConvertida = new Date();
        try {
            fechaConvertida = format.parse(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return fechaConvertida;
    }
}

package com.jorgerubira.ejerciciosspringweb.services;

import com.jorgerubira.ejerciciosspringweb.exceptions.OperacionEnListaException;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio01ListaNombresService;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio10Ficheros;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;

@Service  //Poner al incluir en Maven.
public class Ejercicio10Ficheros implements IEjercicio10Ficheros {
 

    public Ejercicio10Ficheros() {
     
    }


    @Override
    public List<String> getLista() {
        String ruta = "C:\\";
        List<String> lineas = new ArrayList<>();
        try {
            lineas = Files.readAllLines(Paths.get(ruta));

        } catch (Exception e) {
            e.getMessage();
        }

        return lineas;
    }

}

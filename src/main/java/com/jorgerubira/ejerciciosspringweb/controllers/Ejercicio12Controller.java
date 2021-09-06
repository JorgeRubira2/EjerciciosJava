package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.domain.Universitario;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ejercicio12")
public class Ejercicio12Controller {

    String rutaBase = "D:\\NetBeansProjects\\EjerciciosJava\\src\\main\\java\\com\\jorgerubira\\resources\\";

    @GetMapping("/pagina")
    public String o() {
        return "ej11/vista.html";
    }

    @GetMapping("/leer")
    public void leerCSV() {
        String fichero = "DatosUniversidad.csv";

        BufferedReader bufferLectura = null;
        try {

            bufferLectura = new BufferedReader(new FileReader(rutaBase + fichero));

            String linea = bufferLectura.readLine();

            while (linea != null) {
                String[] campos = linea.split(";");
                try {

                    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                    Date fechaConvertida;
                    fechaConvertida = format.parse(campos[10]);

                    Universitario u = new Universitario(/*ESTA MAL ESTO */1, Integer.parseInt(campos[0]), campos[1], campos[2], campos[3], campos[4], campos[5], Integer.parseInt(campos[6]),
                            Integer.parseInt(campos[7]), Integer.parseInt(campos[8]), Integer.parseInt(campos[9]), fechaConvertida);

                    linea = bufferLectura.readLine();
                } catch (ParseException ex) {
                    Logger.getLogger(Ejercicio12Controller.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Cierro el buffer de lectura
            if (bufferLectura != null) {
                try {
                    bufferLectura.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}

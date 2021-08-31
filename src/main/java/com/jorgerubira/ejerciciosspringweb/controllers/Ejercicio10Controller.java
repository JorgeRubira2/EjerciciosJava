package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.domain.Fichero;
import java.io.File;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/ejercicio10")
public class Ejercicio10Controller {

    @GetMapping("/listaficheros") //URL A LLAMAR
    public String listarFicheros(Model model, String ruta) {
        if (ruta == null) {
            ruta = "C:\\";
        }
        File f = new File(ruta);
        ArrayList<Fichero> nombres = new ArrayList<>();
        if (f.isDirectory()) {
            File[] ficherosInternos = f.listFiles();
            for (File ficherosinterno : ficherosInternos) {
                ficherosinterno.getParent();
                try {
                    nombres.add(new Fichero(ficherosinterno.getName(), ficherosinterno.isDirectory(), ficherosinterno.getAbsolutePath()));
                } catch (Exception e) {

                }
            }
        
        }
        model.addAttribute("nombres", nombres);
        model.addAttribute("ruta", f.getAbsolutePath());
        model.addAttribute("volver", f.getParent());
        return "ej10/vista";
    }

}

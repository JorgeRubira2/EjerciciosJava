package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.entities.Imagen;
import com.jorgerubira.ejerciciosspringweb.entities.Solicitud;
import com.jorgerubira.ejerciciosspringweb.repositories.SolicitudRepository;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Isabel
 */
@Controller
@RequestMapping("/ejercicio12")
public class Ejercicio12ImportarCSV {

    @Autowired
    private SolicitudRepository soliRepo;

    @Value("${carpetas.recursos.hiberus}")
    private String rutaRecursos;

    @GetMapping("/ver")
    public String verPagina(Model model) {
        return "ej12/csv";
    }

    //...............................................COMPROBAR FALLOS.........................................
    @ResponseBody
    @PostMapping("/subir")
    public String subirCSV(Model model, MultipartFile fichero) {
        String ruta = rutaRecursos + "\\ej12\\csv\\" + fichero.getOriginalFilename();

        File f = new File(ruta);
        f.getParentFile().mkdirs();

        try {
            Files.copy(fichero.getInputStream(), f.toPath(), StandardCopyOption.REPLACE_EXISTING);
            Files.lines(f.toPath())
                    .map(x -> {
                        String[] campos = x.split(";");

                        Solicitud sol = new Solicitud(
                                null,
                                campos[0],
                                campos[1],
                                campos[2],
                                campos[3],
                                campos[4],
                                campos[5],
                                Integer.parseInt(campos[6]),
                                Integer.parseInt(campos[7]),
                                Integer.parseInt(campos[8]),
                                Double.parseDouble(campos[9]),
                                convertirFecha(campos[10]));
                        return sol;
                    })
                    .forEach(x -> soliRepo.save(x));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ej12/csv";
    }
    
    private Date convertirFecha(String fecha){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date convertir = null;
        try {
            convertir = formato.parse(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return convertir;
    }
}

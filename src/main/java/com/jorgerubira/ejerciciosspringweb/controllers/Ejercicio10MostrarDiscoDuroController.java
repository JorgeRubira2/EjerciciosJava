/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ejercicio10")
public class Ejercicio10MostrarDiscoDuroController {

    @GetMapping("/hdd")
    public String mostrarDiscoDuro(Model model, String ruta, String download) {
        if (ruta == null) {
            ruta = "C://";
        }

        File f = new File(ruta);

        if (f.exists()) {
            File[] ficheros = f.listFiles();
            //ArrayList directorios = new ArrayList<>();
            //ArrayList archivos = new ArrayList<>();
            ArrayList archivos = new ArrayList<>();

            model.addAttribute("ubicacion", f.getName());

            /*for (File fichero : ficheros) {
                if(fichero.isDirectory()){
                    directorios.add(fichero);
                }
                
                if(fichero.isFile()){
                    archivos.add(fichero);
                }
            }*/
            for (File fichero : ficheros) {
                if (fichero.isDirectory()) {
                    archivos.add(fichero.getAbsolutePath() + "\\");
                }

                if (fichero.isFile()) {
                    archivos.add(fichero.getName());
                }
            }
            model.addAttribute("datos", archivos);

           /* if (download != null) {
                URL urlObj = null;
                ReadableByteChannel rbcObj = null;
                FileOutputStream fOutStream = null;
                try {
                    urlObj = new URL("http://localhost:8090/ejercicio10/hdd/");
                    rbcObj = Channels.newChannel(urlObj.openStream());
                    fOutStream = new FileOutputStream(download);

                    fOutStream.getChannel().transferFrom(rbcObj, 0, Long.MAX_VALUE);
                    System.out.println("! File Successfully Downloaded From The Url !");
                } catch (Exception ioExObj) {
                    System.out.println("Problem Occured While Downloading The File= " + ioExObj.getMessage());
                } finally {
                    try {
                        if (fOutStream != null) {
                            fOutStream.close();
                        }
                        if (rbcObj != null) {
                            rbcObj.close();
                        }
                    } catch (Exception ioExObj) {
                        System.out.println("Problem Occured While Closing The Object= " + ioExObj.getMessage());
                    }
                }
            } else {
                System.out.println("File Not Present! Please Check!");
            }*/

        }

        return ("ej10/hdd");
        //return ("redirect:hdd/{ruta}");
    }

    /*@GetMapping("/hdd/{ruta}")
    public String mostrarDirectorio(Model model,String ruta){
        
        mostrarDiscoDuro(model, ruta);
        
        return ("ej10/hdd");
        
    }*/
}

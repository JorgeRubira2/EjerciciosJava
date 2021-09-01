/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.entities.Universidad;
import com.jorgerubira.ejerciciosspringweb.repositories.UniversidadRepository;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Jesus
 */
@Controller
@RequestMapping("/ej12")
public class Ejercicio12LeerCsv {

    @Autowired
    private UniversidadRepository service;

    @GetMapping
    public String inicio() {
        return "/ej12/inicio";
    }
    
    @PostMapping("/guardar")
    public String guardar(Model m, MultipartFile csv) {
        List<String> result=new ArrayList<>();
        try {
            InputStream aux=csv.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(aux, "UTF-8"));
            String linea;
            String s="";
            while( (linea = br.readLine()) != null ){
                s=s+linea+"\n";    
            }
            String []sVector=s.split("\n");
            
            result=Arrays.asList(sVector);
            System.out.println("vector list "+result.get(0));
            result.remove(0);
            System.out.println("vector list "+result.get(0));
        result.stream().filter(x->x.contains(";")).forEach(x->{
            String[] objeto=x.split(";");

                try {
                    service.save(new Universidad(null,objeto[0],objeto[1],objeto[2],objeto[3],objeto[4],objeto[5],Integer.parseInt(objeto[6]),Integer.parseInt(objeto[7]),Integer.parseInt(objeto[8]),Double.parseDouble(objeto[9]),new SimpleDateFormat("dd/MM/yyyy").parse(objeto[10])));
                } catch (ParseException ex) {
                    Logger.getLogger(Ejercicio12LeerCsv.class.getName()).log(Level.SEVERE, null, ex);
                }
           
        });
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio12LeerCsv.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        m.addAttribute("universidad", service.findAll());
        return "/ej12/tabla";
    }

}

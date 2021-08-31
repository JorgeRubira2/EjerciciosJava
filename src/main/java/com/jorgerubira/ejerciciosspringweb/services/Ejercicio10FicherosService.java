/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.services;

import com.jorgerubira.ejerciciosspringweb.domain.Ficheros;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio10FicheroService;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jesus
 */
@Service
public class Ejercicio10FicherosService implements IEjercicio10FicheroService {
    
    private Ficheros f;
    
    @Override
    public List<File> ficheros(String ruta) {
        File f=new File(ruta);
        List<File> ficherosInt=null;
        if(f.isDirectory()){
            ficherosInt=Arrays.asList(f.listFiles());
            return ficherosInt;
        }else{
            return ficherosInt;
        }
    }

    @Override
    public List<Ficheros> fichClas(String ruta) {
        List<File> f=ficheros(ruta);
        List<Ficheros> fObject=new ArrayList<>();      
        f.forEach(x->{
            boolean dir=x.isDirectory();
            fObject.add(new Ficheros(x,dir));
            
        });
        return fObject;
    }
    
}

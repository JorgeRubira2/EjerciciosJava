/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.interfaces;

import com.jorgerubira.ejerciciosspringweb.domain.Ficheros;
import java.io.File;
import java.util.List;




/**
 *
 * @author Jesus
 */

public interface IEjercicio10FicheroService {
    
    public List<File> ficheros (String ruta); //obtener archivos
    public List<Ficheros> fichClas(String ruta); //lista ficheros
}

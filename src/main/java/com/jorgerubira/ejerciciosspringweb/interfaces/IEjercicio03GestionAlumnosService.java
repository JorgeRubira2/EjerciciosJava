/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.interfaces;

import com.jorgerubira.ejerciciosspringweb.domain.Alumno;
import java.util.List;
import java.util.Optional;

/**
 * El servicio Gestion Alumnos permite gestionar alumnos. Dar de alta y de baja alumnos.
 * El campo que servirá para identificarlos será el id
 */
public interface IEjercicio03GestionAlumnosService {
    
    /**
     * Busca el ID del alumno y si ya existe modifica el resto de campos (o lo sustituye)
     * si no está el ID lo inserta.
     */
    public void guardarAlumno(Alumno alumno);
        
    /**
     * Borra alumno del codigo indicado.
     * @param codigo
     */
    public void borrarAlumno(Long codigo);
    
    /**
     * Devuelve todos los alumnos
     */
    public List<Alumno> getAlumnos();
    
    /**
     * Devuelve la información del alumno del codigo indicado
     */
    public Optional<Alumno> getAlumno(Long codigo);    

    /**
     * Busca los alumnos filtrando por nombre 
     */
    public List<Alumno> getAlumnos(String buscar);
    
    
}

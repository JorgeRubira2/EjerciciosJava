/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.domain.Alumno;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio03GestionAlumnosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author PC
 */
public class Ejercicio03GestionAlumnosController {
     @Autowired
    // @RequestMapping("/Ejercicio3")
private IEjercicio03GestionAlumnosService miListadeAlumnos;
     @GetMapping("/alumnos")
     
     public void guardarAlumno(Alumno alumno){
         if(alumno!=null && miListadeAlumnos.getAlumno(alumno.getCodigo())==null){
             miListadeAlumnos.guardarAlumno(alumno);
         }
     }
      public void borrarAlumno(Long codigo){
          if(miListadeAlumnos.getAlumno(codigo)!=null){
              miListadeAlumnos.borrarAlumno(codigo);
          }
      }
     
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosjava.interfaces;

import com.jorgerubira.ejerciciosjava.pojo.Persona;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author PC
 */
public interface IPersonasRepository {
    
    List<Persona> buscarPersona(String nombrePersona);
    List<Persona> buscarPersonaEntreFechas(Date fechaDesde, Date fechaHasta);
    List<Persona> buscarPersonasDeUnaCiudad(String ciudad);
    Optional<Persona> leerPersona(String nombre);
    boolean altaPersona(Persona persona);   //Devuelve si ha sido insertada la persona
    boolean modificarPersona(String nombre, Persona persona);   //Devuelve si ha sido insertada la persona
    
}


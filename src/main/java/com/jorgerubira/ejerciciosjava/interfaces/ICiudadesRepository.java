package com.jorgerubira.ejerciciosjava.interfaces;

import com.jorgerubira.ejerciciosjava.pojo.Ciudad;
import java.util.List;
import java.util.Optional;

public interface ICiudadesRepository {
    
    List<Ciudad> buscarCiudad(String ciudad);
    Optional<Ciudad> leerCiudad(String nombre);
    boolean altaCiudad(Ciudad persona);   //Devuelve si ha sido insertada la ciudad
    boolean modificarCiudad(String nombre, Ciudad persona);   //Devuelve si ha sido insertada la ciudad

    
}

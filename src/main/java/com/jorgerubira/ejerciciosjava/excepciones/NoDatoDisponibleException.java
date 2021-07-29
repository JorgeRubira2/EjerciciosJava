package com.jorgerubira.ejerciciosjava.excepciones;

public class NoDatoDisponibleException extends Exception {

    public NoDatoDisponibleException(String datoNoDisponible) {
        super("No disponible el dato " + datoNoDisponible);
    }
    
}

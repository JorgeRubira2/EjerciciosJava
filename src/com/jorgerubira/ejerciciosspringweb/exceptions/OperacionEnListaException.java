
package com.jorgerubira.ejerciciosspringweb.exceptions;


public class OperacionEnListaException extends Exception {

    public OperacionEnListaException(String nombre) {
        super("El elemento " + nombre + " está repetido");
    }
    
}

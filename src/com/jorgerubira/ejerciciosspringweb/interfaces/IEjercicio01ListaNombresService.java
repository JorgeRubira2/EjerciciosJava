package com.jorgerubira.ejerciciosspringweb.interfaces;

import java.util.List;

import com.jorgerubira.ejerciciosspringweb.exceptions.OperacionEnListaException;

public interface IEjercicio01ListaNombresService {
	/**
     * Inserta un elemento en la lista. Devuelve una excepción
     */
    public void altaNombre(String nombre) throws OperacionEnListaException;

    /**
     * Da de baja un nombre si este existe.
     */
    public void bajaNombre(String nombre);

    /**
     * Devuelve una lista con los nombres.
     */
    public List<String> getLista();
}

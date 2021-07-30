package com.jorgerubira.ejerciciosjava.interfaces;

import com.jorgerubira.ejerciciosjava.pojo.Compra;
import java.util.Date;
import java.util.List;


public interface IComprasRepository {
    
    /**
     * Devuelve todas las compras realizadas por una persona concreta.
     */
    List<Compra> obtenerComprasDeUnaPersona(String persona);
    
    /**
     * Devuelve todas las compras realizadas por una persona concreta entre unas fechas concretas.
     */
    List<Compra> obtenerComprasDeUnaPersonaEntreFechas(String persona, Date fechaDesde, Date fechaHasta);

    /**
     * Devuelve todas las compras realizadas entre unas fechas concretas.
     */
    List<Compra> obtenerComprasEntreFechas(Date fechaDesde, Date fechaHasta);

}

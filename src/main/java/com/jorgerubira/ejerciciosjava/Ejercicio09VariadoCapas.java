package com.jorgerubira.ejerciciosjava;

import com.jorgerubira.ejerciciosjava.interfaces.ICiudadesRepository;
import com.jorgerubira.ejerciciosjava.interfaces.IPersonasRepository;
import com.jorgerubira.ejerciciosjava.pojo.Ciudad;
import java.util.Date;
import java.util.List;


public class Ejercicio09VariadoCapas {
    
    IPersonasRepository repoPersonas;
    ICiudadesRepository repoCiudades;

    public Ejercicio09VariadoCapas(IPersonasRepository repoPersonas) {
        this.repoPersonas = repoPersonas;
    }
    
    /**
     * Busca las personas hayan nacido entre dos fecha introducidas y devuelve las ciudades donde están estas personas.
     * Utilizar StreamsParalelos para optimizar el rendimiento de servidores si es posible.
     * Las ciudades no se deben repetir.
     */
    public List<Ciudad> buscarCiudadesDePersonasNacidasEn(Date fechaDesde, Date fechaHasta){
        throw new RuntimeException("Pendiente de hacer");
    }
    
    
    /**
     * Calcular el total de productos comprados por las personas de una ciudad.
     * Utilizar StreamsParalelos para optimizar el rendimiento de servidores.
     */
    public Long calcularComprasDeUnaCiudad(String ciudad){
        throw new RuntimeException("Pendiente de hacer");
    }    
    
    
    
}

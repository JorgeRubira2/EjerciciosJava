package com.jorgerubira.ejerciciosspringweb.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fichero{
    
    private String nombre;
    boolean esDirectorio;
    String rutaAbsoluta;
}

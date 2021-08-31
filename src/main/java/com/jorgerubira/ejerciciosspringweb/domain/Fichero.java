/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Aineto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fichero {
    private String nombre;
    private boolean directorio;
    private String rutaFichero;
    
    
    
}

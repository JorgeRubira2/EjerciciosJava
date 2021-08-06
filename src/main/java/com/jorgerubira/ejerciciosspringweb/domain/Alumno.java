/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alumno {

    private long codigo;
    private String nombre;
    private String telefono;
    private String direccion;
    
    @Override
    public boolean equals(Object obj){
        return this.codigo==(((Alumno)obj).codigo);
    }
    
    
}

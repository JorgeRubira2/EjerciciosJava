package com.jorgerubira.explicaciones.D20210804.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data       //Crear los set y los get
@AllArgsConstructor     //Constructor con todos los atributos
@NoArgsConstructor      //Constructor con ningun parametro.
public class Persona {
    private String nombre;
    private Integer edad; 
}

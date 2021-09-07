/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name = "Imagenes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Imagen {
    
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY) 
    private Integer id;
       
    @NotNull
    private String descripcion ;
    
    @NotNull
    private String nombre;
    
    
    
}

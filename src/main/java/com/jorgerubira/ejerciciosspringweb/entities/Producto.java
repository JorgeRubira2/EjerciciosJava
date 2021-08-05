/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Productos")
@Data
@NoArgsConstructor
public class Producto {
    
    @Id
    private Long id;
    
    @NotNull
    private String referencia;
    
    private String nombre;
    private Double precioVenta;
    private Boolean activo;

}

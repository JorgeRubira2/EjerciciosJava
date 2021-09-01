/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author janus
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="imagenessubida")
public class ImagenSubida {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull
    @Column(nullable=false)
    private String  rutaAlmacenamiento;
    
    @NotNull
    @Column(nullable=false)
    private String  nombreOriginal;
    private String  descripcion;
}

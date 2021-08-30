/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="imagenes")
public class Imagen {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull
    @Column(nullable=false)
    private String  url;
    private String  descripcion;
    private Date    fechaHoraFichero;
    private String  tipoImagen;
    private String  orientacion;
    private String  contenido;
    private String  categoria;
    private String  uso;
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.entities;

import com.jorgerubira.explicaciones.D20210902.relaciones.entities.Telefono;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "carreras_universidad")
public class CarrerasUniversidad {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
        
    private Integer curso_academico;
    private String estudio;
    private String localidad;
    private String centro;
    private String tipo_centro;
    private String tipo_estudido;
    private Integer plazas_ofertadas;
    private Integer plazas_matriculadas;
    private Integer plazas_solicitadas;
    private Double indice_ocupacion;
    private LocalDate fecha_actualizacion;    
}

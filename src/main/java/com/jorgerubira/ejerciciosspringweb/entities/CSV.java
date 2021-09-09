package com.jorgerubira.ejerciciosspringweb.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "csv")
public class CSV {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer curso_academico;
    private String estudio;
    private String localidad;
    private String centro;
    private String tipo_centro;
    private String tipo_estudio;
    private Integer plazas_ofertadas;
    private Integer plazas_matriculadas;
    private Integer plazas_solicitadas;
    private Double indice_ocupacion;
    private Date fecha_actualizacion;
}
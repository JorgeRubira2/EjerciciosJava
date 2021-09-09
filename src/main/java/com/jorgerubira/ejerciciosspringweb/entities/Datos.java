package com.jorgerubira.ejerciciosspringweb.entities;

import java.util.Date;
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


@Data  
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "datos")
public class Datos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    
    @NotNull
    private int curso_academico;
    private String estudio;
    private String localidad;
    private String centro;
    private String tipo_centro;
    private String tipo_estudio;
    private int plazas_ofertadas;
    private int plazas_matriculadas;
    private int plazas_solicitadas;
    private double indice_ocupacion;
    private Date fecha_actualizacion;
}

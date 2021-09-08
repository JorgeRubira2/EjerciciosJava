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


@Data  
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "datos")
public class Datos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    
    @NotNull
    private int CURSO_ACADEMICO;
    private String ESTUDIO;
    private String LOCALIDAD;
    private String CENTRO;
    private String TIPO_CENTRO;
    private String TIPO_ESTUDIO;
    private int PLAZAS_OFERTADAS;
    private int PLAZAS_MATRICULADAS;
    private int PLAZAS_SOLICITADAS;
    private double INDICE_OCUPACION;
    //private date FECHA_ACTUALIZACION;
}

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
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

@Table(name = "plaza")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Plaza {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer cursoAcademico;
    private String estudio;
    private String localidad;
    private String centro;
    private String tipoCentro;
    private String tipoEstudio;
    private Integer plazasOfertadas;
    private Integer plazasMatriculadas;
    private Integer plazasSolicitadas;
    private Double indiceOcupacion;
    private Date fechaActualizacion;   
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Plaza")

public class Plaza {

    @Id
    private Long id;
    private String cursoAcademico;
    private String estudio;
    private String localidad;
    private String centro;
    private String tipoCentro;
    private String tipoEstudio;
    private Integer plazasOfertadas;
    private Integer plazasMatriculadas;
    private Integer plazasSolicitadas;
    private Integer indiceOcupacion;

    //@Temporal(javax.persistence.TemporalType.DATE) preguntar
    private Date fechaActualizacion;
}

package com.jorgerubira.ejerciciosspringweb.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  
@NoArgsConstructor
@AllArgsConstructor
@Entity  
@Table(name = "universidad")
public class Universidad {
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
package com.jorgerubira.ejerciciosspringweb.entities;


import java.util.Date;
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
@Table(name = "solicitudes_csv")
@NoArgsConstructor
@AllArgsConstructor
@Entity  
public class Csv {
    
    @Id        
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    
    private Integer curso_academico;
    
    @NotNull           
    private String estudio;
   
    private String localidad;
    private String centro;
    private String tipoCentro;
    private String tipoEstudio;
    private Integer plazasOfertadas;
    private Integer plazasMatriculadas;
    private Integer plazasSolicitadas;
    private Float indiceOcupacion;
    
    private Date fechaActualizacion;
    
}

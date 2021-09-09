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
@Table(name = "DatosAcademicos")
@NoArgsConstructor
@AllArgsConstructor
@Entity  
public class Csv {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
            
    private String codigo;
    private String descripcion;
    
}

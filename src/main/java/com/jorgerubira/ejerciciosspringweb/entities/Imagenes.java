package com.jorgerubira.ejerciciosspringweb.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "imagenes")
@NoArgsConstructor
@AllArgsConstructor
@Entity  
public class Imagenes {
    
    @Id
    private Long id;
            
    private String codigo;
    private String descripcion;
    
}

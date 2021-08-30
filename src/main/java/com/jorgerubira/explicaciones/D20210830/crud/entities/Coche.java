
package com.jorgerubira.explicaciones.D20210830.crud.entities;

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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Coches")
public class Coche {    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //Probar
    private Integer id;
    
    @Column(nullable = false)
    private String matricula;
    
    private String marca;
    private String modelo;
    private Integer anyoMatriculacion;      //Probar
}

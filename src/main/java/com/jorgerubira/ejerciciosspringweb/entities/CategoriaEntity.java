
package com.jorgerubira.ejerciciosspringweb.entities;

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
@Table(name = "estilos")
public class CategoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String estilo;
    private String categoria;
}

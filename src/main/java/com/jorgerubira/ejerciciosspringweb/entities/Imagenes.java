package com.jorgerubira.ejerciciosspringweb.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Imagenes {

    @Id
    private Integer id;
    private String nombre;
    private String descripcion;
    private String ruta;

}

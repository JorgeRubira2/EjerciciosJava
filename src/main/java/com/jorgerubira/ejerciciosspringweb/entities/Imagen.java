
package com.jorgerubira.ejerciciosspringweb.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Isabel
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "imagenes")
public class Imagen {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private String codigo;
    @Column(name = "nombre_fichero")
    private String nombreFichero;
}

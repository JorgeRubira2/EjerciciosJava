
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
    private String ruta;
    @Column(name = "nombre_fichero")
    private String nombreFichero;

    public void get() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

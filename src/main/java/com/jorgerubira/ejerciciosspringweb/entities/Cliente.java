package com.jorgerubira.ejerciciosspringweb.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  
@NoArgsConstructor
@AllArgsConstructor
@Entity     //Poner las anotaciones que creas convenientes.
public class Cliente {
    @Id
    private Long id;    //Poner las anotaciones
   private String nombre;
   private String apellidos;
   private String direccion;
   private String ciudad;
   private String pais;
   private Integer codigo_postal;
   private Integer telefono;
   private String email;
   private String nombre_cuenta; 
   private String titulo;
   private String descripcion;
    
    
}

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
    //poner aquí los campos que creas conveniente.
}

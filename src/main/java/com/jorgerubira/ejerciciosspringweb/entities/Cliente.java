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
    private long id;    //Poner las anotaciones
    //poner aquí los campos que creas conveniente.
    private String firstName;
    private String lastName;
    private String title;
    private String email;
    private String phone;
    private String primaryAccount;
    private String description;
    private String calle;
    private String ciudad;
    private String estado;
    private String pais;
    private Integer cp;
}

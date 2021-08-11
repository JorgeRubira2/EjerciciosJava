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
@Entity     //Poner las anotaciones que creas convenientes.
@Table( name= "Cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    //Poner las anotaciones
    //poner aquí los campos que creas conveniente.
    private String firstName;
    private String lastName;
    private String title;
    private String primaryAccount;
    private String officePhone;
    private String email;
    private String description;
    private String direction;
    private String city;
    
}

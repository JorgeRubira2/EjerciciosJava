/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  
@NoArgsConstructor
@AllArgsConstructor
@Entity (name="Bolsa") 
public class Bolsa {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Integer id;
      private Date hora;
      private String titulo;
      private String operacion;
      private Integer titulos;
      private Double precio;

public Bolsa(Date hora, String titulo, String operacion, Integer titulos, Double precio) {
      this.hora=hora;
      this.titulo=titulo;
      this.operacion=operacion;
      this.titulos=titulos;
      this.precio=precio;//To change body of generated methods, choose Tools | Templates.
    }
   
    
}

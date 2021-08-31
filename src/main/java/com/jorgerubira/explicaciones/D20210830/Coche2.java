/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.explicaciones.D20210830;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data   //Set y los get
@Getter //Solo implementa los Get
//@Setter   //Solo implementa los Set
@NoArgsConstructor
@AllArgsConstructor
public class Coche2 {
    private int ruedas;
    
    @Setter
    private int puertas;  
}

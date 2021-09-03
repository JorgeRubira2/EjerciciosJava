/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medalla {

    private String pais;
    private String deporte;
    private String medalla; //Oro, Plata, Bronce
    private String tipoDeporte;
    private String deportistas;
    //private List<String> deportistas; //Posible mejora nivel PRO, una medalla puede tener varios deportistas.
    
}

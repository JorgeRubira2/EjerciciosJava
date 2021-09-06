/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.domain;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medalla {

	public String pais;
	public String deporte;
	public String medalla; //Oro, Plata, Bronce
	public String tipoDeporte;
	public String deportistas;
    //private List<String> deportistas; //Posible mejora nivel PRO, una medalla puede tener varios deportistas.
    
}

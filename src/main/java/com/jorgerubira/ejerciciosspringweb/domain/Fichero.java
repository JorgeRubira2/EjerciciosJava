package com.jorgerubira.ejerciciosspringweb.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fichero implements Serializable {
	private String nombre;
	private boolean directorio;
	private String rutaAbs;
	

}

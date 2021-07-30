package com.jorgerubira.ejerciciosjava.excepciones;


	import java.io.IOException;

	public class FormatoNoValidoException extends IOException{

	    public FormatoNoValidoException() {
	        super("El formato del fichero no es valido");
	    }
	    
	}


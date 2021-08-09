
package com.jorgerubira.ejerciciosspringweb.controllers;

import com.jorgerubira.ejerciciosspringweb.exceptions.OperacionEnListaException;
import com.jorgerubira.ejerciciosspringweb.services.Ejercicio01ListaNombresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Disponemos un servicio IEjercicio01ListaNombresService ya implementado que permite almacenar y borrar nombres de personas.
 * Se pide exponerlo en una web de manera que podremos ver las personas que están en la lista y añadir o quitar nombres.
 * Los nombres no se deben repetir, el servicio lanza una excepción en ese caso.
 */
public class Ejercicio01ListaNombresController {
    @Autowired
	private Ejercicio01ListaNombresService miLista;
	@GetMapping("/ListaNombres")
        public String Nombres(Model model){
        model.addAttribute("Nombre", 0);
        return "listaPersonas";
    }
	@PostMapping("/ListaNombres")
	public String aniadirNombre(Model model,String nombre) throws OperacionEnListaException {
		if(!miLista.getLista().contains(nombre)) {
			miLista.altaNombre(nombre);	
		}
		model.addAttribute(nombre,miLista.getLista());
		return "listaPersonas";
	}
	@PostMapping("/ListaNombresEliminar")
	public void eliminarNombre(Model model,String nombre) {
		if(miLista.getLista().contains(nombre)) {
			miLista.bajaNombre(nombre);
		}
	}
	
}

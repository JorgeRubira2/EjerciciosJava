
package com.jorgerubira.ejerciciosspringweb.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jorgerubira.ejerciciosspringweb.exceptions.OperacionEnListaException;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio01ListaNombresService;

/**
 * Disponemos un servicio IEjercicio01ListaNombresService ya implementado que
 * permite almacenar y borrar nombres de personas. Se pide exponerlo en una web
 * de manera que podremos ver las personas que están en la lista y añadir o
 * quitar nombres. Los nombres no se deben repetir, el servicio lanza una
 * excepción en ese caso.
 */

@Controller
@RequestMapping("/ejercicio1")
public class Ejercicio01ListaNombresController {
	@Autowired
	private IEjercicio01ListaNombresService lis;

	@GetMapping("/listaPersonas")
	public String listaPersona(Model model) {
		model.addAttribute("persona", lis.getLista());
		return "ej01/listaPersonas";

	}

	@PostMapping("/anadir")
	public String altaNombre(Model model, String nombre) {
		try {
			lis.altaNombre(nombre);
		} catch (OperacionEnListaException e) {

			e.printStackTrace();
		}
		model.addAttribute("persona", lis.getLista());

		return "ej01/listaPersonas";

	}

	@PostMapping("/remove")
	public String bajaNombre(Model model, String nombre) {

		lis.bajaNombre(nombre);
		model.addAttribute("persona", lis.getLista());

		return "ej01/listaPersonas";

	}
}

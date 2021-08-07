package com.jorgerubira.ejerciciosspringweb.services;

import com.jorgerubira.ejerciciosspringweb.domain.Alumno;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio03GestionAlumnosService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

/**
 * Servicio que implementa el interface de gestion de alumnos
 */
@Service
public class Ejercicio03GestionAlumnosService implements IEjercicio03GestionAlumnosService {
	private List<Alumno> alumnos = new ArrayList<>();

	@Override
	public void guardarAlumno(Alumno alumno) {
		if (alumnos.stream().anyMatch(x -> alumno.getCodigo() == x.getCodigo())) {
			alumnos.removeIf(x -> alumno.getCodigo() == x.getCodigo());
			alumnos.add(alumno);
		} else {
			alumnos.add(alumno);
		}

	}

	@Override
	public void borrarAlumno(Long codigo) {
		alumnos.removeIf(x -> x.getCodigo() == codigo);
	}

	@Override
	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	@Override
	public Optional<Alumno> getAlumno(Long codigo) {
		Optional<Alumno> alu = alumnos.stream().filter(x -> x.getCodigo() == codigo).findFirst();
		return alu;
	}

	@Override
	public List<Alumno> getAlumnos(String buscar) {
		List<Alumno> res = alumnos.stream().filter(x -> x.getNombre().equals(buscar)).collect(Collectors.toList());
		return res;
	}

}

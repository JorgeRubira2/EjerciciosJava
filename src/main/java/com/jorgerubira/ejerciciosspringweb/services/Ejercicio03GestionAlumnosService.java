package com.jorgerubira.ejerciciosspringweb.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jorgerubira.ejerciciosspringweb.domain.Alumno;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio03GestionAlumnosService;

@Service
public class Ejercicio03GestionAlumnosService implements IEjercicio03GestionAlumnosService {

	private List<Alumno> alumnos=new ArrayList<>();

	@Override
	public void guardarAlumno(Alumno alumno) {
		if(alumnos.stream().noneMatch(x->x.getCodigo() == alumno.getCodigo())) {//insertar
			alumno.setCodigo((long) (Math.random()*99999999));
			alumnos.add(alumno);
		}else {//actualizar
			alumnos.removeIf(x -> x.getCodigo() == alumno.getCodigo());
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
		if (alumnos.stream().noneMatch(x->x.getCodigo() == codigo)){ 
			throw new NullPointerException();
		}else {
			return  alumnos.stream()
					.filter(x -> x.getCodigo()== codigo)
					.findFirst();
		}
	}


	@Override
	public List<Alumno> getAlumnos(String buscar) {
		if (buscar==null || alumnos.stream().noneMatch(x->x.getNombre().equalsIgnoreCase(buscar))){
			throw new NullPointerException();
		}
		return  alumnos.stream()
				.filter(x -> x.getNombre().equalsIgnoreCase(buscar))
				.collect(Collectors.toList());
	}

}

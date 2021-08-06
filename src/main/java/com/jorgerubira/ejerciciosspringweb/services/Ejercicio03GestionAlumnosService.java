package com.jorgerubira.ejerciciosspringweb.services;

import com.jorgerubira.ejerciciosspringweb.domain.Alumno;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio03GestionAlumnosService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 * Servicio que implementa el interface de gestion de alumnos
 */
@Service 
public class Ejercicio03GestionAlumnosService implements IEjercicio03GestionAlumnosService {

    private List<Alumno> listaAlumnos = new ArrayList<>();

    @Override
    public void guardarAlumno(Alumno alumno) {
        if (alumno != null) {
            if (listaAlumnos.stream().anyMatch(x -> alumno.getCodigo() == x.getCodigo())) {
                listaAlumnos.removeIf(x -> alumno.getCodigo() == x.getCodigo());
                listaAlumnos.add(alumno);
            } else {
                listaAlumnos.add(alumno);
            }
        }
    }

    @Override
    public void borrarAlumno(Long codigo) {
        listaAlumnos.removeIf(x -> codigo.equals(x.getCodigo()));
    }

    @Override
    public List<Alumno> getAlumnos() {
        return listaAlumnos;
    }

    @Override
    public Optional<Alumno> getAlumno(Long codigo) {
        return listaAlumnos.stream()
                .filter(x -> codigo.equals(x.getCodigo()))
                .findFirst();
    }

    @Override
    public List<Alumno> getAlumnos(String buscar) {
        return listaAlumnos.parallelStream()
                .filter(x -> buscar.equalsIgnoreCase(buscar))
                .collect(Collectors.toList());
    }

}

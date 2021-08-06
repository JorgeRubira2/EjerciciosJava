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
        if (alumno != null && !listaAlumnos.contains(alumno)) {
            listaAlumnos.add(alumno);
        } else {
            int posicion = listaAlumnos.indexOf(alumno);
            listaAlumnos.set(posicion, alumno);
        }
    }

    @Override
    public void borrarAlumno(Long codigo) {
        if (codigo != null) {
            Optional<Alumno> aux = getAlumno(codigo);
            if (aux.isPresent() && listaAlumnos.contains(aux.get())) {
                int posicion = listaAlumnos.indexOf(aux.get());
                listaAlumnos.remove(posicion);
            }
        }

    }

    @Override
    public List<Alumno> getAlumnos() {
        return listaAlumnos;
    }

    @Override
    public Optional<Alumno> getAlumno(Long codigo) {
        Optional<Alumno> devolver = Optional.ofNullable(null);

        List<Alumno> aux = listaAlumnos.stream().filter(x -> x.getCodigo() == codigo).collect(Collectors.toList());
        if (aux.size() > 0) {
            devolver = Optional.of(aux.get(0));
        }

        return devolver;
    }

    @Override
    public List<Alumno> getAlumnos(String buscar) {
        return listaAlumnos.stream().filter(x -> x.getNombre().equals(buscar)).collect(Collectors.toList()); //To change body of generated methods, choose Tools | Templates.
    }

}

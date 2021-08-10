package com.jorgerubira.ejerciciosspringweb.services;

import com.jorgerubira.ejerciciosspringweb.domain.Alumno;
import com.jorgerubira.ejerciciosspringweb.exceptions.OperacionEnListaException;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio03GestionAlumnosService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 * Servicio que implementa el interface de gestion de alumnos
 */

@Service 
public class Ejercicio03GestionAlumnosService implements IEjercicio03GestionAlumnosService {

    @Autowired
    private List<Alumno> listaAlumnos = new ArrayList<>();


    @Override
    
    public void guardarAlumno(Alumno alumno) {
       Optional<Alumno> alumnoGuardar = listaAlumnos.stream()
               .filter(al -> al.getCodigo() == alumno.getCodigo())
               .findFirst();
       
        if (alumnoGuardar.isPresent()) {
            alumnoGuardar.get().setCodigo(alumno.getCodigo());
            alumnoGuardar.get().setNombre(alumno.getNombre());
            alumnoGuardar.get().setDireccion(alumno.getDireccion());
            alumnoGuardar.get().setTelefono(alumno.getTelefono());
        } else {
            listaAlumnos.add(alumno);
        }
    }

    @Override
    public void borrarAlumno(Long codigo) {
        listaAlumnos.removeIf(alumno -> alumno.getCodigo() == codigo);
    }

    @Override
    public List<Alumno> getAlumnos() {
        return listaAlumnos;
    }

    @Override
    public Optional<Alumno> getAlumno(Long codigo) {
        return listaAlumnos.stream()
                .filter(alumno -> codigo == alumno.getCodigo())
                .findFirst();
    }

    @Override
    public List<Alumno> getAlumnos(String buscar) {
        return listaAlumnos.stream()
                .filter(alumno -> buscar.equals(alumno.getNombre()))
                .collect(Collectors.toList());
    }
    
}

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

    private List<Alumno> listaAlumnos = new ArrayList<>();

    public Ejercicio03GestionAlumnosService() {
        listaAlumnos.add(new Alumno(1L, "Mario", "7865", "C/dfcvbg"));
        listaAlumnos.add(new Alumno(2L, "Ana", "444", "C/rwr"));
        listaAlumnos.add(new Alumno(3L, "Pedro", "6753648", "C/pogbtr"));
        listaAlumnos.add(new Alumno(4L, "Lucas", "6543895", "C/hygdtfrb"));
    }
    
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
            alumno.setCodigo((long)(Math.random()*999999999));
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

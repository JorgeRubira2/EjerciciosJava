package com.jorgerubira.ejerciciosspringweb.services;


import com.jorgerubira.ejerciciosspringweb.domain.Alumno;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio03GestionAlumnosService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;
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
        OptionalLong maxCodigo = alumnos.stream()
                                .mapToLong(x -> x.getCodigo())
                                .max();
        
        if (maxCodigo.isPresent()){
            alumno.setCodigo(maxCodigo.getAsLong()+1);
        } else {
            alumno.setCodigo(1);
        }
        
        alumnos.add(alumno);
    }

    @Override
    public void borrarAlumno(Long codigo) {
        Optional<Alumno> alumno = alumnos.stream()
                                .filter( x-> x.getCodigo()== codigo.longValue())
                                .findFirst();
        if (alumno.isPresent()){
            alumnos.remove(alumno.get());
        } else {
            System.out.println("Alumno no encontrado");
            //throw new Exception();
        }
    }

    @Override
    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    @Override
    public Optional<Alumno> getAlumno(Long codigo) {
        Optional<Alumno> alumno = alumnos.stream()
                                .filter( x-> x.getCodigo()== codigo.longValue())
                                .findFirst();
        if (alumno.isPresent()){
            return alumno;
        } else {
            return Optional.of(new Alumno());
        }
    }

    @Override
    public List<Alumno> getAlumnos(String buscar) {
        return alumnos.stream()
                       .filter(x -> buscar.equals(x.getNombre()))
                       .collect(Collectors.toList());
    }
    
}

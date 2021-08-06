package com.jorgerubira.ejerciciosspringweb.services;

import com.jorgerubira.ejerciciosspringweb.domain.Alumno;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio03GestionAlumnosService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


/**
 * Servicio que implementa el interface de gestion de alumnos
 */
@Service
public class Ejercicio03GestionAlumnosService implements IEjercicio03GestionAlumnosService {

    List<Alumno> alumnos = new ArrayList<>();

    @Override
    public void guardarAlumno(Alumno alumno) {
         Optional<Alumno> alu = alumnos.stream()
                    .filter(a->a.getCodigo()==(alumno.getCodigo()))
                    .findFirst();
//         OptionalLong ultimoCodigo = alumnos.stream()
//                                        .mapToLong(a->a.getCodigo())
//                                        .max();

         if(alu.isPresent()){
             alu.get().setNombre(alumno.getNombre());
             alu.get().setDireccion(alumno.getDireccion());
             alu.get().setTelefono(alumno.getTelefono());
         } else {
//             if(ultimoCodigo.isPresent()){
//                 alumno.setCodigo(ultimoCodigo.getAsLong()+1);
//             } else {
//                 alumno.setCodigo(1);
//             }
             alumnos.add(alumno);
         }
    }

    @Override
    public void borrarAlumno(Long codigo) {
        alumnos.removeIf(a->a.getCodigo()==codigo);
    }

    @Override
    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    @Override
    public Optional<Alumno> getAlumno(Long codigo) {
        return alumnos.stream()
                        .filter(a->a.getCodigo()==codigo)
                        .findFirst();
    }

    @Override
    public List<Alumno> getAlumnos(String buscar) {
        return alumnos.stream()
                        .filter(a->buscar.equals(a.getNombre()))
                        .collect(Collectors.toList());
    }
    
}

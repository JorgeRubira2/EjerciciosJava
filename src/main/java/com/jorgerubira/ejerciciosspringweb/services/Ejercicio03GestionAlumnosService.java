package com.jorgerubira.ejerciciosspringweb.services;

import com.jorgerubira.ejerciciosspringweb.domain.Alumno;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio03GestionAlumnosService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;



/**
 * Servicio que implementa el interface de gestion de alumnos
 */
@Service
public class Ejercicio03GestionAlumnosService implements IEjercicio03GestionAlumnosService {


    private List<Alumno> listaAlumnos = new ArrayList<>();
    
    @Override
    public void guardarAlumno(Alumno alumno) {
        if (alumno == null) {
            throw new NullPointerException();
        } else if (listaAlumnos.stream()
                .noneMatch(var1 -> var1.getCodigo() == (alumno.getCodigo()))) {
            
            OptionalLong ultima = listaAlumnos.stream()
                    .mapToLong(var1 -> var1.getCodigo())
                    .max();

            if (ultima.isEmpty()){
                alumno.setCodigo(1);
            } else {
                alumno.setCodigo(ultima.getAsLong()+1);
            }


            listaAlumnos.add(alumno);

        } else {
            Alumno aux = listaAlumnos.stream()
                    .filter(var1 -> var1.getCodigo() == alumno.getCodigo())
                    .findFirst().get();

            aux.setDireccion(alumno.getDireccion());
            aux.setCodigo(alumno.getCodigo());
            aux.setNombre(alumno.getNombre());
            aux.setTelefono(alumno.getTelefono());

        }
    }

    @Override
    public void borrarAlumno(Long codigo) {
        Optional<Alumno> alumno = listaAlumnos.stream()
                .filter(v1 -> v1.getCodigo() == codigo)
                .findFirst();

        if (alumno.isPresent()) {
            listaAlumnos.remove(alumno.get());
        }
    }

    @Override
    public List<Alumno> getAlumnos() {
        return listaAlumnos;
    }

    @Override
    public Optional<Alumno> getAlumno(Long codigo) {
        Optional<Alumno> alumno = listaAlumnos.stream()
                .filter(v1 -> v1.getCodigo() == codigo)
                .findFirst();

        return alumno;
    }

    @Override
    public List<Alumno> getAlumnos(String buscar) {
        return listaAlumnos.stream()
                .filter(v1 -> v1.getNombre().equals(buscar))
                .collect(Collectors.toList());
    }
}

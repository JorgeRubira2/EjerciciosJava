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

    private List<Alumno> listaAlumnos = new ArrayList<>();

    public Ejercicio03GestionAlumnosService() {
        listaAlumnos.add(new Alumno(1L, "cristian", "123344", "los olivos"));
        listaAlumnos.add(new Alumno(2L, "yesenia", "123", "los olivos"));
        listaAlumnos.add(new Alumno(3L, "milagros", "455", "los olivos"));
                
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
            /* Prueba*/
            /* Fin prueba*/

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
        Optional<Alumno> alumno = listaAlumnos.stream()
                .filter(x -> x.getCodigo() == codigo.longValue())
                .findFirst();
        if (alumno.isPresent()) {
            return alumno;
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<Alumno> getAlumnos(String buscar) {
        return listaAlumnos.stream()
                .filter(alumno -> buscar.equals(alumno.getNombre()))
                .collect(Collectors.toList());
    }
    
}
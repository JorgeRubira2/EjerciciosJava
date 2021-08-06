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
        if (listaAlumnos.size() > 0 && alumno != null) {
            long contar = listaAlumnos.stream().filter(x -> x.getCodigo() == alumno.getCodigo()).count();
            if (contar == 0) {
                listaAlumnos.add(alumno);
            } else {
                listaAlumnos.forEach(x -> {
                                        if (x.getCodigo() == alumno.getCodigo()) {
                                            x.setNombre(alumno.getNombre());
                                            x.setDireccion(alumno.getDireccion());
                                            x.setTelefono(alumno.getTelefono());
                                        };
                                    });
            }
        } else {
            listaAlumnos.add(alumno);
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

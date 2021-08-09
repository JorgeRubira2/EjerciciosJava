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

    private List<Alumno> lista = new ArrayList<>();

    @Override
    public void guardarAlumno(Alumno alumno) {
        Optional<Alumno> a = lista.stream().filter(x -> alumno.getCodigo() == x.getCodigo())
                .findFirst();
        int numeroAleatorio = (int) (Math.random() * 9998 + 1);
        if (a.isPresent()) {
            a.get().setNombre(alumno.getNombre());
            a.get().setTelefono(alumno.getTelefono());
            a.get().setDireccion(alumno.getDireccion());

        } else {
            alumno.setCodigo(numeroAleatorio);
            lista.add(alumno);
        }

    }

    @Override
    public void borrarAlumno(Long codigo) {

        lista.removeIf(x -> x.getCodigo() == codigo);
    }

    @Override
    public List<Alumno> getAlumnos() {

        return lista;
        /* return Collections.unmodifiableList(lista);*/
    }

    @Override
    public Optional<Alumno> getAlumno(Long codigo) {
        Optional<Alumno> alumno = lista.stream()
                .filter(x -> x.getCodigo() == codigo).findFirst();

        return alumno;

    }

    @Override
    public List<Alumno> getAlumnos(String buscar) {
        return lista.stream().
                filter(x -> x.getNombre().equals(buscar))
                .collect(Collectors.toList());
    }

}

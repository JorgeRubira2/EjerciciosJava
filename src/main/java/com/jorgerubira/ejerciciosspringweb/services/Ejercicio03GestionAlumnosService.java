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

    //Hecho controlador para probar que funciona la lista
    public Ejercicio03GestionAlumnosService() {
            listaAlumnos.add(new Alumno(1, "Isabel", "132131", "Dirección"));
    }

    
    @Override
    public void guardarAlumno(Alumno alumno){
      //  listaAlumnos.stream()
               // .filter(x -> x.getCodigo());

        Alumno nuevoAlumno = new Alumno();
        nuevoAlumno.setCodigo(alumno.getCodigo());
        nuevoAlumno.setNombre(alumno.getNombre());
        nuevoAlumno.setTelefono(alumno.getDireccion());
        nuevoAlumno.setDireccion(alumno.getDireccion());
       
    }

    @Override
    public void borrarAlumno(Long codigo) {
        listaAlumnos.removeIf(x -> x.getCodigo()==codigo);
    }

    @Override
    public List<Alumno> getAlumnos() {
        return listaAlumnos;
    }

    @Override
    public Optional<Alumno> getAlumno(Long codigo) {
        
        Optional<Alumno> alumno = listaAlumnos.stream()
                           .filter(x -> x.getCodigo()== codigo)
                           .findFirst();   
        return alumno;
    }

    @Override
    public List<Alumno> getAlumnos(String buscar) {
        return listaAlumnos.stream()
                           .filter(x -> buscar.equals(x.getNombre()))
                           .collect(Collectors.toList());
    }
}

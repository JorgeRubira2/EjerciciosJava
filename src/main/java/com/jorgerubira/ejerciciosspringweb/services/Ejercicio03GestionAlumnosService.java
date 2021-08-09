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
    
    private List<Alumno> alumnos = new ArrayList<>();
    
    @Override
    public void guardarAlumno(Alumno alumno) {        
        Alumno alu = alumnos.stream()
                .filter(x -> x.getCodigo() == alumno.getCodigo())
                .findFirst()
                .orElse(null);        
        if (alu == null) {
            alumnos.add(alumno);
        } else {
            alu.setCodigo(alumno.getCodigo());
            alu.setNombre(alumno.getNombre());
            alu.setTelefono(alumno.getTelefono());
            alu.setDireccion(alumno.getDireccion());
        }
    }
    
    @Override
    public void borrarAlumno(Long codigo) {
        alumnos.removeIf(x -> x.getCodigo() == codigo);
        
    }
    
    @Override
    public List<Alumno> getAlumnos() {
        return alumnos;
    }
    
    @Override
    public Optional<Alumno> getAlumno(Long codigo) {
        Optional<Alumno> opt = alumnos.stream()
                .filter(x -> x.getCodigo() == codigo)
                .findFirst();
        
        return opt;
    }
    
    @Override
    public List<Alumno> getAlumnos(String buscar) {
        
        List<Alumno> resultado = alumnos.stream()
                .filter(x -> x.getNombre().equalsIgnoreCase(buscar))
                .collect(Collectors.toList());
        return resultado;
    }
    
}

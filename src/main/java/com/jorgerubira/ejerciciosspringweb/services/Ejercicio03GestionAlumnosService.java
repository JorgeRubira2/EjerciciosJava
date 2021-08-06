package com.jorgerubira.ejerciciosspringweb.services;

import com.jorgerubira.ejerciciosspringweb.domain.Alumno;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio03GestionAlumnosService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;


@Service
public class Ejercicio03GestionAlumnosService implements IEjercicio03GestionAlumnosService {

    private List<Alumno> alumnos=new ArrayList<>();
    
    @Override
    public void guardarAlumno(Alumno alumno) {
        Optional<Alumno> al = Optional.empty();
        if(alumno.getCodigo() != 0){
            al = alumnos.stream()
                    .filter(x->x.getCodigo() == alumno.getCodigo())
                    .findFirst();
        }
        
        if(al.isPresent()){
           
        }
    }

    @Override
    public void borrarAlumno(Long codigo) {
        alumnos.stream()
                .filter(x->x.getCodigo() == codigo.longValue())
                .findFirst();
        
    }

    @Override
    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    @Override
    public Optional<Alumno> getAlumno(Long codigo) {
        Optional<Alumno> al = alumnos.stream()
                .filter(x->x.getCodigo() == codigo.longValue())
                .findFirst();
        if(al.isPresent()){
            return al;
        }else{
            return Optional.empty();
        }
    }

    @Override
    public List<Alumno> getAlumnos(String buscar) {
        return alumnos.stream()
                .filter(x->x.getNombre().equals(buscar))
                .collect(Collectors.toList());
    }
    
}

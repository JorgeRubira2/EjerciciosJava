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
    
    public Ejercicio03GestionAlumnosService(){ 
        alumnos.add(new Alumno(1L,"A","B","C"));
    }
    
    @Override 
    public void guardarAlumno(Alumno alumno) {
       
       Optional<Alumno> nuevoAlumno = alumnos.stream().filter(x->x.getCodigo()==alumno.getCodigo()).findFirst();
       
       if(nuevoAlumno.isPresent()){
           nuevoAlumno.get().setNombre(alumno.getNombre());
           nuevoAlumno.get().setTelefono(alumno.getTelefono());
           nuevoAlumno.get().setDireccion(alumno.getDireccion());
           
       }else{
           alumnos.add(alumno);
       }
    }

    @Override
    public void borrarAlumno(Long codigo) {
        alumnos.removeIf(x->x.getCodigo()==codigo);
    }

    @Override
    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    @Override
    public Optional<Alumno> getAlumno(Long codigo) {
        Optional<Alumno> alumno = alumnos.stream().filter(x->x.getCodigo()==codigo).findFirst();   
        return alumno;
    }

    @Override
    public List<Alumno> getAlumnos(String buscar) {
        List<Alumno> alumno = alumnos.stream().filter(x->x.getNombre().equals(buscar)).collect(Collectors.toList());
        return alumno;
        
    }
    
}

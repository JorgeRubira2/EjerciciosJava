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

    private List<Alumno> alumnos=new ArrayList<>();
    
    public Ejercicio03GestionAlumnosService() {
        //Añadimos varios nombres por defecto.
        alumnos.add(new Alumno(1, "Pepe", "600900300", "Calle la pergola n12"));
        alumnos.add(new Alumno(2, "Sara", "600903300", "Calle Kaiser d02"));
    }
    
    @Override
    public void guardarAlumno(Alumno alumno) {
        Optional<Alumno> a = alumnos.stream().filter(t->t.getCodigo()==alumno.getCodigo()).findFirst();
        
        if(!a.isPresent()){
            alumnos.add(alumno);
        }else{
            alumnos.remove(a.get());
            alumnos.add(new Alumno(a.get().getCodigo(),alumno.getNombre(),alumno.getTelefono(),alumno.getDireccion()));
        }
    }

    @Override
    public void borrarAlumno(Long codigo) {
        
        Optional<Alumno> a = alumnos.stream().filter((t) -> {
            return t.getCodigo() == codigo;
        }).findAny();
        if(a.isPresent()){
        alumnos.remove(a.get());
        }
    }

    @Override
    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    @Override
    public Optional<Alumno> getAlumno(Long codigo) {
        /*
        return alumnos.stream().map((t) -> {
            if(t.getCodigo()==codigo){
                return t;
            }else{
                //return (Alumno)Optional.empty().get();
                return Optional.of(new Alumno()).get();
            }
        }).findAny();
        */
        
      /*  if(a.isPresent()){
            return a;
        }else{
            Optional<Alumno> b = Optional.of(new Alumno());
            return b;
        }*/
      
      return alumnos.stream().filter((t) -> {
          return t.getCodigo() == codigo;
      }).findAny();
      
    }

    @Override
    public List<Alumno> getAlumnos(String buscar) {
        return alumnos.stream().filter((t) -> {
            return t.getNombre().equals(buscar); 
        }).collect(Collectors.toList());
    }
    
}

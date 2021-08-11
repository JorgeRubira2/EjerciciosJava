package com.jorgerubira.ejerciciosspringweb.services;

import com.jorgerubira.ejerciciosspringweb.domain.Alumno;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio03GestionAlumnosService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


@Service
public class Ejercicio03GestionAlumnosService implements IEjercicio03GestionAlumnosService {
    private final List<Alumno> alumnos=new ArrayList<>();
    
    public Ejercicio03GestionAlumnosService() {
        
        Alumno alumno = new Alumno();
        alumno.setCodigo(1);
        alumno.setNombre("Maria");
        alumno.setTelefono("722162789");
        alumno.setDireccion("calle");
        
        Alumno alumno2 = new Alumno();
        alumno2.setCodigo(2);
        alumno2.setNombre("Rosa");
        alumno2.setTelefono("789");
        alumno2.setDireccion("calle2");
        alumnos.add(alumno);
        alumnos.add(alumno2);
    }

    
    @Override
    public void guardarAlumno(Alumno alumno) {
        
         Optional <Alumno>  nuevo = alumnos.stream().filter(x -> alumno.getCodigo()== x.getCodigo()).findFirst();
    
        if (nuevo.isPresent())
        {
            nuevo.get().setCodigo(alumno.getCodigo());
            nuevo.get().setNombre(alumno.getNombre());
            nuevo.get().setTelefono(alumno.getTelefono());            
            nuevo.get().setDireccion(alumno.getDireccion());
            
          
        }else{
            long codigo=(int)(Math.random()*99999999);
            nuevo.get().setCodigo(codigo);
            nuevo.get().setNombre(alumno.getNombre());
            nuevo.get().setTelefono(alumno.getTelefono());            
            nuevo.get().setDireccion(alumno.getDireccion());
            alumnos.add(alumno); 
                         
        }
                   
    }

    @Override
    public void borrarAlumno(Long codigo) {
         for (int i=0;i< alumnos.size() ;i++){
                if (alumnos.get(i).getCodigo() == codigo.intValue() )
                    alumnos.remove(i);
            }
               
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Alumno> getAlumnos() {
        
        return alumnos;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<Alumno> getAlumno(Long codigo) {
        
       // Optional<Alumno>  nuevo =  Optional.empty();      
        //Optional <Alumno> alumno2 = Optional.empty();
            Alumno alumno2 = new Alumno();   
        
         for (int i=0;i < alumnos.size() ;i++){
                if (alumnos.get(i).getCodigo() == codigo.intValue()) {
                    alumno2 = alumnos.get(i);
                }
         }
        
        
        return Optional.of(alumno2);
    }

    @Override
    public List<Alumno> getAlumnos(String buscar) {
         List<Alumno> alumnos2=new ArrayList<>();
         
         for (int i=0;i < alumnos.size() ;i++){
                if (alumnos.get(i).getNombre().equals(buscar) ){
                    alumnos2.add(alumnos.get(i));
                    System.out.println (" Si       HAY      " );
                }
            }
         
         System.out.println ("          PASOOOOOOOOOOO  ");
         int cantidad = 0;
         cantidad = alumnos2.size();
                       
          String cantidad2 = String.valueOf(cantidad);
          System.out.println ("       Cantidad    " + cantidad2 ) ;
        return alumnos2;
         
    }
    
}

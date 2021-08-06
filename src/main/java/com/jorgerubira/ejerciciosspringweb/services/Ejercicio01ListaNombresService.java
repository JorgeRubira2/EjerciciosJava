package com.jorgerubira.ejerciciosspringweb.services;

import com.jorgerubira.ejerciciosspringweb.exceptions.OperacionEnListaException;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio01ListaNombresService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;


@Service  //Poner al incluir en Maven.
public class Ejercicio01ListaNombresService implements IEjercicio01ListaNombresService{

    private List<String> nombres=new ArrayList<>();

    public Ejercicio01ListaNombresService() {
        //Añadimos varios nombres por defecto.
        //nombres.add("Ana");
        //nombres.add("Juan");
       // nombres.add("Pepe");
    }
    
    @Override
    public void altaNombre(String nombre) throws OperacionEnListaException {
        if (nombre==null){ //Desde el exterior se debe comprobar si vale nulo.
            throw new NullPointerException();
        }
        if (nombres.stream().noneMatch(x->x.equals(nombre))){
            nombres.add(nombre);
        }else{
            throw new OperacionEnListaException(nombre);
        }
    }

    @Override
    public void bajaNombre(String nombre) {
        nombres.remove(nombre);
    }

    @Override
    public List<String> getLista() {
        //Devuelve una lista inmutable.
        return Collections.unmodifiableList(nombres);
    }
    
}

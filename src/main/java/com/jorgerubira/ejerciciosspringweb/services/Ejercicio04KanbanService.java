package com.jorgerubira.ejerciciosspringweb.services;

import com.jorgerubira.ejerciciosspringweb.domain.TareaKanban;
import com.jorgerubira.ejerciciosspringweb.exceptions.OperacionEnListaException;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio04KanbanService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;


/**
 * Implementa la interface IEjercicio04KanbanService
 */

/**
 private String codigo; //Se generará al azar al insertar. UUID.randomUUID().toString();
    private String descripcion; //Descripcion de la tarea
    private String propietario; //Persona que está realizando esta tarea.
    private Integer horasEstimacion; //Tiempo estimado en la tarea. Opcional
    private Integer horasTrabajadas; //Tiempo de trabajo en la tarea. 
    private String estado; //Roadmap (Pensada), Waiting (Se hace en breve), Working (Realizandose), Done (Finalizada). 
    
 */

@Service
public class Ejercicio04KanbanService implements IEjercicio04KanbanService {

    private List<TareaKanban> listaTareaKanban = new ArrayList<>();
    
    public Ejercicio04KanbanService() {
        //listaTareaKanban.add(new TareaKanban("Crear formulario", "Mario", horasEstimacion, horasTrabajadas, "Done"));
        //listaTareaKanban.add(new TareaKanban("Modificar tabla", "Sonia", 10, null, "Waiting"));
    }
    
    @Override
    public void crearTarea(String descripcion, Integer horasEstimacion) {
       //listaTareaKanban.add();
    }

    @Override
    public void modificarTarea(String codigo, String descripcion, Integer horasEstamacion) throws OperacionEnListaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void asignarPersona(String codigo, String persona) throws OperacionEnListaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void imputarHorasTrabajadas(String codigo, int horas) throws OperacionEnListaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cambiarEstado(String codigo, String persona) throws OperacionEnListaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TareaKanban> getTareas() {
        return listaTareaKanban;
    }

    @Override
    public Optional<TareaKanban> getTarea(String codigo) {
        return listaTareaKanban.stream()
                .filter(TareaKanban -> codigo == TareaKanban.getCodigo())
                .findFirst();
    }
    
}

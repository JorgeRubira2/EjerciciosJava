package com.jorgerubira.ejerciciosspringweb.services;

import com.jorgerubira.ejerciciosspringweb.domain.TareaKanban;
import com.jorgerubira.ejerciciosspringweb.exceptions.OperacionEnListaException;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio04KanbanService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Implementa la interface IEjercicio04KanbanService
 */
public class Ejercicio04KanbanService implements IEjercicio04KanbanService {

    private List<TareaKanban> taskList = new ArrayList<>();

    @Override
    public void crearTarea(String descripcion, Integer horasEstimacion) {

        TareaKanban task = new TareaKanban(UUID.randomUUID().toString(),
                descripcion, null, horasEstimacion, 0, "Roadmap");

        taskList.add(task);
    }

    @Override
    public void modificarTarea(String codigo, String descripcion, Integer horasEstamacion) throws OperacionEnListaException {
        Optional<TareaKanban> task = this.getTarea(codigo);

        if (task.isPresent()) {
            task.get().setDescripcion(descripcion);
            task.get().setHorasEstimacion(horasEstamacion);
        }
    }

    @Override
    public void asignarPersona(String codigo, String persona) throws OperacionEnListaException {
        Optional<TareaKanban> task = this.getTarea(codigo);
        
        if (task.isPresent()) {
            task.get().setPropietario(persona);
        }
    }

    @Override
    public void imputarHorasTrabajadas(String codigo, int horas) throws OperacionEnListaException {
        Optional<TareaKanban> task = this.getTarea(codigo);
        int horasAcumuladoas = task.get().getHorasTrabajadas();
        if (task.isPresent()) {

            task.get().setHorasTrabajadas(horas + horasAcumuladoas);
        }
    }

    @Override
    public void cambiarEstado(String codigo, String estado) throws OperacionEnListaException {
       Optional<TareaKanban> task = this.getTarea(codigo);
        
        if (task.isPresent()) {
            task.get().setEstado(estado);
        }
    }

    @Override
    public List<TareaKanban> getTareas() {
        return taskList;
    }

    @Override
    public Optional<TareaKanban> getTarea(String codigo) {
        Optional<TareaKanban> task = taskList.stream()
                .filter(v1 -> v1.getCodigo().equals(codigo))
                .findFirst();

        return task;
    }

}

package com.jorgerubira.ejerciciosspringweb.services;

import com.jorgerubira.ejerciciosspringweb.domain.TareaKanban;
import com.jorgerubira.ejerciciosspringweb.exceptions.OperacionEnListaException;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio04KanbanService;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 * Implementa la interface IEjercicio04KanbanService
 */
@Service
public class Ejercicio04KanbanService implements IEjercicio04KanbanService {

    private List<TareaKanban> tareas = new LinkedList<>();

    
     public Ejercicio04KanbanService(){
         
        /*crearTarea("Tarea test 1", 100);
        crearTarea("Tarea test 2", 10);
        crearTarea("Tarea test 3", 10);
        crearTarea("Tarea test 4", 10);*/
        /*tareas.add(new TareaKanban(UUID.randomUUID().toString(), "Tarea ejemplo Roadmap", "Xema", 10, 10, "Roadmap"));
        
        tareas.add(new TareaKanban(UUID.randomUUID().toString(), "Tarea ejemplo Roadmap", "Xema", 10, 10, "Roadmap"));
        tareas.add(new TareaKanban(UUID.randomUUID().toString(), "Tarea ejemplo Roadmap", "Xema", 10, 0, "Roadmap"));
        tareas.add(new TareaKanban(UUID.randomUUID().toString(), "Tarea ejemplo Waiting", "Xena", 10, 15, "Waiting"));
        tareas.add(new TareaKanban(UUID.randomUUID().toString(), "Tarea ejemplo Working", "Pepe", 10, 20, "Working"));
        //tareas.add(new TareaKanban(UUID.randomUUID().toString(), "Tarea ejemplo Working", null, 10, 8, "Working"));
        tareas.add(new TareaKanban(UUID.randomUUID().toString(), "Tarea ejemplo Done", "Marta", 10, 80, "Done"));
        //tareas.add(new TareaKanban(UUID.randomUUID().toString(), "Tarea ejemplo Done", null, 10, 11, "Done"));
        //tareas.add(new TareaKanban(UUID.randomUUID().toString(), "Tarea ejemplo Done", null, 10, 12, "Done"));
        tareas.add(new TareaKanban(UUID.randomUUID().toString(), "Tarea ejemplo Done", "Juana", 10, 9, "Done"));
        //tareas.add(new TareaKanban(UUID.randomUUID().toString(), "Tarea ejemplo Done", null, 10, 0, "Done"));
        //tareas.add(new TareaKanban(UUID.randomUUID().toString(), "Tarea ejemplo Done", null, 1, 100, "Done"));*/
    }

    @Override
    public void crearTarea(String descripcion, Integer horasEstimacion) {
        //tareas.add(new TareaKanban(String.valueOf((int) (Math.random() * 99999)), descripcion, null, horasEstimacion, 0, "Roadmap"));
        tareas.add(new TareaKanban(UUID.randomUUID().toString(), descripcion, null, horasEstimacion, 0, "Roadmap"));
    }

    @Override
    public void modificarTarea(String codigo, String descripcion, Integer horasEstamacion) throws OperacionEnListaException {
        try {
            TareaKanban t = tareas.stream().filter(x -> x.getCodigo().equals(codigo)).findFirst().get();

            tareas.remove(t);

            t.setCodigo(codigo);
            t.setDescripcion(descripcion);
            t.setHorasEstimacion(horasEstamacion);

            tareas.add(t);

        } catch (Exception e) {
            throw new OperacionEnListaException("Tarea con dicho código no encontrado");
        }

    }

    @Override
    public void asignarPersona(String codigo, String persona) throws OperacionEnListaException {
        try {
            this.getTarea(codigo).get().setPropietario(persona);
        } catch (Exception e) {
            throw new OperacionEnListaException("Tarea con dicho código no encontrado");
        }

    }

    @Override
    public void imputarHorasTrabajadas(String codigo, int horas) throws OperacionEnListaException {

        try {
            int horasTrabajadas = this.getTarea(codigo).get().getHorasTrabajadas();
            this.getTarea(codigo).get().setHorasTrabajadas(horasTrabajadas + horas);
        } catch (Exception e) {
            throw new OperacionEnListaException("Tarea con dicho código no encontrado");
        }

    }

    @Override
    public void cambiarEstado(String codigo, String persona) throws OperacionEnListaException {
        try {
            this.getTarea(codigo).get().setEstado(persona);
        } catch (Exception e) {
            throw new OperacionEnListaException("Tarea con dicho código no encontrado");
        }
    }

    @Override
    public List<TareaKanban> getTareas() {
        return tareas.stream().collect(Collectors.toList());
    }

    @Override
    public Optional<TareaKanban> getTarea(String codigo) {
        return tareas.stream().filter(x -> x.getCodigo().equals(codigo)).findFirst();
    }

}

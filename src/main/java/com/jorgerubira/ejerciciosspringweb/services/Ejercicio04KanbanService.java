package com.jorgerubira.ejerciciosspringweb.services;

import com.jorgerubira.ejerciciosspringweb.domain.TareaKanban;
import com.jorgerubira.ejerciciosspringweb.exceptions.OperacionEnListaException;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio04KanbanService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository

@Service
public class Ejercicio04KanbanService implements IEjercicio04KanbanService {

    private List<TareaKanban> tareas = new ArrayList<>();

    public Ejercicio04KanbanService() {
        TareaKanban tarea = new TareaKanban();
        tarea.setCodigo("1");
        tarea.setDescripcion("Implementar ventana de pago");
        tarea.setEstado("Roadmap");
        tarea.setHorasEstimacion(0);
        tarea.setHorasTrabajadas(0);
        tarea.setPropietario("Maria Perez");
        tareas.add(tarea);
        
        tarea = new TareaKanban();
        tarea.setCodigo("5");
        tarea.setDescripcion("Implementar ventana de pago 2");
        tarea.setEstado("Roadmap");
        tarea.setHorasEstimacion(0);
        tarea.setHorasTrabajadas(0);
        tarea.setPropietario("Maria Perez");
        tareas.add(tarea);        

        tarea = new TareaKanban();
        tarea.setCodigo("2");
        tarea.setDescripcion("Implementar ventana de rechazo");
        tarea.setEstado("Waiting");
        tarea.setHorasEstimacion(0);
        tarea.setHorasTrabajadas(0);
        tarea.setPropietario("Rosa Perez");
        tareas.add(tarea);

        tarea = new TareaKanban();
        tarea.setCodigo("3");
        tarea.setDescripcion("Implementar ventana de registro");
        tarea.setEstado("Working");
        tarea.setHorasEstimacion(0);
        tarea.setHorasTrabajadas(0);
        tarea.setPropietario("Luis Gonzalez");
        tareas.add(tarea);

        tarea = new TareaKanban();
        tarea.setCodigo("4");
        tarea.setDescripcion("Implementar imagen");
        tarea.setEstado("Done");
        tarea.setHorasEstimacion(0);
        tarea.setHorasTrabajadas(0);
        tarea.setPropietario("Ana Lopez");
        tareas.add(tarea);

    }

    @Override
    public void crearTarea(String descripcion, Integer horasEstimacion) {

        TareaKanban tarea = new TareaKanban();
        long codigoTarea = (long) (Math.random() * 99999999);
        String codigo;
        codigo = String.valueOf(codigoTarea);
        tarea.setCodigo(codigo);
        tarea.setDescripcion(descripcion);
        tarea.setHorasEstimacion(horasEstimacion);
        tarea.setEstado("Roadmap");
        tarea.setHorasTrabajadas(0);
        tarea.setPropietario(null);
        tareas.add(tarea);

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarTarea(String codigo, String descripcion, Integer horasEstimacion) throws OperacionEnListaException {

        try {

            Optional<TareaKanban> tarea = tareas.stream().filter(x -> codigo.equals(x.getCodigo())).findFirst();

            if (tarea.isPresent()) {

                tarea.get().setDescripcion(descripcion);
                tarea.get().setHorasEstimacion(horasEstimacion);
            } else {
                throw new OperacionEnListaException("No se encontro");
            }

        } catch (OperacionEnListaException e) {
            System.out.println("error");
        }

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void asignarPersona(String codigo, String persona) throws OperacionEnListaException {

        try {

            Optional<TareaKanban> tarea = tareas.stream().filter(x -> codigo.equals(x.getCodigo())).findFirst();

            if (tarea.isPresent()) {

                tarea.get().setPropietario(persona);
            } else {
                throw new OperacionEnListaException("No se encontro");
            }

        } catch (OperacionEnListaException e) {
            System.out.println("error");
        }

// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void imputarHorasTrabajadas(String codigo, int horas) throws OperacionEnListaException {
        try {

            Optional<TareaKanban> tarea = tareas.stream().filter(x -> codigo.equals(x.getCodigo())).findFirst();

            if (tarea.isPresent()) {

                tarea.get().setHorasTrabajadas((Integer) horas);
            } else {
                throw new OperacionEnListaException("No se encontro");
            }

        } catch (OperacionEnListaException e) {
            System.out.println("error");
        }
    }

    @Override
    public void cambiarEstado(String codigo, String estado) throws OperacionEnListaException {
        try {

            Optional<TareaKanban> tarea = tareas.stream().filter(x -> codigo.equals(x.getCodigo())).findFirst();

            if (tarea.isPresent()) {

                tarea.get().setEstado(estado);
            } else {
                throw new OperacionEnListaException("No se encontro");
            }

        } catch (OperacionEnListaException e) {
            System.out.println("error");
        }
    }

    @Override
    public List<TareaKanban> getTareas() {
        return tareas;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<TareaKanban> getTarea(String codigo) {
        TareaKanban tarea = new TareaKanban();

        for (int i = 0; i < tareas.size(); i++) {
            if (tareas.get(i).getCodigo().equals(codigo)) {
                tarea = tareas.get(i);
            }
        }
        return Optional.of(tarea);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

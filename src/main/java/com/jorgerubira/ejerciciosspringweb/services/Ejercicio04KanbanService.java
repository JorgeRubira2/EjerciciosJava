package com.jorgerubira.ejerciciosspringweb.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.jorgerubira.ejerciciosspringweb.domain.TareaKanban;
import com.jorgerubira.ejerciciosspringweb.exceptions.OperacionEnListaException;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio04KanbanService;


/**
 * Implementa la interface IEjercicio04KanbanService
 */
@Service
public class Ejercicio04KanbanService implements IEjercicio04KanbanService {

	public List<TareaKanban> tareas = new ArrayList<>();

	@Override
	public void crearTarea(String descripcion, Integer horasEstimacion) {
		TareaKanban nuevo = new TareaKanban();
		nuevo.setCodigo(UUID.randomUUID().toString());
		nuevo.setDescripcion(descripcion);
		nuevo.setHorasEstimacion(horasEstimacion);
	}

	@Override
	public void modificarTarea(String codigo, String descripcion, Integer horasEstamacion) throws OperacionEnListaException {
		Optional<TareaKanban> tarea = getTarea(codigo);
		tareas.removeIf(x -> x.getCodigo() == codigo);
		tarea.get().setDescripcion(descripcion);
		tarea.get().setHorasEstimacion(horasEstamacion);
		tareas.add(tarea.get());
	}

	@Override
	public void asignarPersona(String codigo, String persona) throws OperacionEnListaException {
		Optional<TareaKanban> tarea = getTarea(codigo);
		tareas.removeIf(x -> x.getCodigo() == codigo);
		tarea.get().setPropietario(persona);
		tareas.add(tarea.get());
	}

	@Override
	public void imputarHorasTrabajadas(String codigo, int horas) throws OperacionEnListaException {
		Optional<TareaKanban> tarea = getTarea(codigo);
		tareas.removeIf(x -> x.getCodigo() == codigo);
		tarea.get().setHorasTrabajadas(tarea.get().getHorasTrabajadas() + horas);
		tareas.add(tarea.get());
	}

	@Override
	public void cambiarEstado(String codigo, String estado) throws OperacionEnListaException {
		Optional<TareaKanban> tarea = getTarea(codigo);
		tareas.removeIf(x -> x.getCodigo() == codigo);
		tarea.get().setEstado(estado);
		tareas.add(tarea.get());
	}

	@Override
	public List<TareaKanban> getTareas() {
		return tareas;
	}

	@Override
	public Optional<TareaKanban> getTarea(String codigo) {
		if (tareas.stream().noneMatch(x->x.getCodigo() == codigo)){ 
			throw new NullPointerException();
		}else {
			return  tareas.stream()
					.filter(x -> x.getCodigo() == codigo)
					.findFirst();
		}
	}
}

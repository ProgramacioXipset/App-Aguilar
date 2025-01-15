package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Tarea;
import com.example.demo.service.TareaServiceIMPL;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class TareaController {
	@Autowired
	TareaServiceIMPL TareaServiceImpl;
	
	@GetMapping("/Tarea")
	public List<Tarea> listarTareas() {
		return TareaServiceImpl.listarTarea();
	}

	@PostMapping("/Tarea")
	public Tarea salvarTarea(@RequestBody Tarea Tarea) {

		return TareaServiceImpl.guardarTarea(Tarea);
	}

	@GetMapping("/Tarea/{id}")
	public Tarea TareaXID(@PathVariable(name = "id") int Codigo) {

		Tarea Tarea_xid = new Tarea();

		Tarea_xid = TareaServiceImpl.TareaXID(Codigo);

		return Tarea_xid;
	}

	@PutMapping("/Tarea/{id}")
	public Tarea actualizarTarea(@PathVariable(name = "id") int Codigo, @RequestBody Tarea Tarea) {

		Tarea Tarea_seleccionado = new Tarea();
		Tarea Tarea_actualizado = new Tarea();

		Tarea_seleccionado = TareaServiceImpl.TareaXID(Codigo);

		Tarea_seleccionado.setId(Tarea.getId());
		Tarea_seleccionado.setFecha_inicio(Tarea.getFecha_inicio());
		Tarea_seleccionado.setFecha_final(Tarea.getFecha_final());
		Tarea_seleccionado.setDuracion(Tarea.getDuracion());
		Tarea_seleccionado.setUsuario(Tarea.getUsuario());
		Tarea_seleccionado.setGrua(Tarea.getGrua());
		Tarea_seleccionado.setCliente(Tarea.getCliente());
		Tarea_seleccionado.setNota(Tarea.getNota());

		Tarea_actualizado = TareaServiceImpl.actualizarTarea(Tarea_seleccionado);

		return Tarea_actualizado;
	}

	@DeleteMapping("/Tarea/{id}")
	public void eliminarTarea(@PathVariable(name = "id") int Codigo) {
		TareaServiceImpl.eliminarTarea(Codigo);
	}
}

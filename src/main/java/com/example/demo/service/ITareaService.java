package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Tarea;

public interface ITareaService {

	public List<Tarea> listarTarea(); 
	
	public Tarea guardarTarea(Tarea Tarea);	
	
	public Tarea TareaXID(int id);
	
	public Tarea actualizarTarea(Tarea Tarea); 
	
	public void eliminarTarea(int id);
	
}

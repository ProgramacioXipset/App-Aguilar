package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Viatge;

public interface IViatgeService {

	public List<Viatge> listarViatge(); 
	
	public Viatge guardarViatge(Viatge Viatge);	
	
	public Viatge ViatgeXID(int id);
	
	public Viatge actualizarViatge(Viatge Viatge); 
	
	public void eliminarViatge(int id);
	
	public List<Viatge> listarAvuiXAvui();
	
	public List<Viatge> listarAnada();
	
	public List<Viatge> listarTornada();
	
}

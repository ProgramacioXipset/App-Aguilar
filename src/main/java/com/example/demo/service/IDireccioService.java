package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Direccio;

public interface IDireccioService {

	public List<Direccio> listarDireccio(); 
	
	public Direccio guardarDireccio(Direccio Direccio);	
	
	public Direccio DireccioXID(int id);
	
	public Direccio actualizarDireccio(Direccio Direccio); 
	
	public void eliminarDireccio(int id);
	
}

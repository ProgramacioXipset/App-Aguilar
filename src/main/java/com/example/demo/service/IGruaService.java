package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Grua;

public interface IGruaService {

	public List<Grua> listarGrua(); 
	
	public Grua guardarGrua(Grua Grua);	
	
	public Grua GruaXID(int id);
	
	public Grua actualizarGrua(Grua Grua); 
	
	public void eliminarGrua(int id);
	
	
}

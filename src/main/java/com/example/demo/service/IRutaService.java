package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Ruta;

public interface IRutaService {

	public List<Ruta> listarRuta(); 
	
	public Ruta guardarRuta(Ruta Ruta);	
	
	public Ruta RutaXID(int id);
	
	public Ruta actualizarRuta(Ruta Ruta); 
	
	public void eliminarRuta(int id);
	
	
}

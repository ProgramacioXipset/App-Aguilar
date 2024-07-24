package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Camio;

public interface ICamioService {

	public List<Camio> listarCamio(); 
	
	public Camio guardarCamio(Camio Camio);	
	
	public Camio CamioXID(int id);
	
	public Camio actualizarCamio(Camio Camio); 
	
	public void eliminarCamio(int id);
	
}

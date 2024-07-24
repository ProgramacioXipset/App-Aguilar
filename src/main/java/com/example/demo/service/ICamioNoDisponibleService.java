package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.CamioNoDisponible;

public interface ICamioNoDisponibleService {

	public List<CamioNoDisponible> listarCamioNoDisponible(); 
	
	public CamioNoDisponible guardarCamioNoDisponible(CamioNoDisponible CamioNoDisponible);	
	
	public CamioNoDisponible CamioNoDisponibleXID(int id);
	
	public CamioNoDisponible actualizarCamioNoDisponible(CamioNoDisponible CamioNoDisponible); 
	
	public void eliminarCamioNoDisponible(int id);
	
	public List<CamioNoDisponible> findByCamio(int id_camio);
	
	public void deleteByCamio(int id_camio);
	
}

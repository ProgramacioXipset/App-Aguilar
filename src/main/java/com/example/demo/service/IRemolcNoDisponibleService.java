package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.RemolcNoDisponible;

public interface IRemolcNoDisponibleService {

	public List<RemolcNoDisponible> listarRemolcNoDisponible(); 
	
	public RemolcNoDisponible guardarRemolcNoDisponible(RemolcNoDisponible RemolcNoDisponible);	
	
	public RemolcNoDisponible RemolcNoDisponibleXID(int id);
	
	public RemolcNoDisponible actualizarRemolcNoDisponible(RemolcNoDisponible RemolcNoDisponible); 
	
	public void eliminarRemolcNoDisponible(int id);
	
	public List<RemolcNoDisponible> findByRemolc(int id_remolc);
	
	public void deleteByRemolc(int id_remolc);
}

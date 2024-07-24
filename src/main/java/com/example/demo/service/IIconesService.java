package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Icones;

public interface IIconesService {

	public List<Icones> listarIcones(); 
	
	public Icones guardarIcones(Icones Icones);	
	
	public Icones IconesXID(int id);
	
	public Icones actualizarIcones(Icones Icones); 
	
	public void eliminarIcones(int id);
	
}

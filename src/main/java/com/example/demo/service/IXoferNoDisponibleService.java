package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.XoferNoDisponible;

public interface IXoferNoDisponibleService {

	public List<XoferNoDisponible> listarXoferNoDisponible(); 
	
	public XoferNoDisponible guardarXoferNoDisponible(XoferNoDisponible XoferNoDisponible);	
	
	public XoferNoDisponible XoferNoDisponibleXID(int id);
	
	public XoferNoDisponible actualizarXoferNoDisponible(XoferNoDisponible XoferNoDisponible); 
	
	public void eliminarXoferNoDisponible(int id);
	
	public List<XoferNoDisponible> findByXofer(int id_xofer);
	
	public void deleteByXofer(int id_xofer);
}

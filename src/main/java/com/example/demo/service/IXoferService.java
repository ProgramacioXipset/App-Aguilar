package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Xofer;

public interface IXoferService {

	public List<Xofer> listarXofer(); 
	
	public Xofer guardarXofer(Xofer Xofer);	
	
	public Xofer XoferXID(int id);
	
	public Xofer actualizarXofer(Xofer Xofer); 
	
	public void eliminarXofer(int id);
	
	
}

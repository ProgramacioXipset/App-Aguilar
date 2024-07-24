package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Remolc;

public interface IRemolcService {

	public List<Remolc> listarRemolc(); 
	
	public Remolc guardarRemolc(Remolc Remolc);	
	
	public Remolc RemolcXID(int id);
	
	public Remolc actualizarRemolc(Remolc Remolc); 
	
	public void eliminarRemolc(int id);
	
	
}

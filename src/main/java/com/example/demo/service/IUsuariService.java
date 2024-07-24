package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Usuari;

public interface IUsuariService {

	public List<Usuari> listarUsuari(); 
	
	public Usuari guardarUsuari(Usuari Usuari);	
	
	public Usuari UsuariXID(int id);
	
	public Usuari actualizarUsuari(Usuari Usuari); 
	
	public void eliminarUsuari(int id);
	
	
}

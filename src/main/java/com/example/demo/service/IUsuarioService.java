package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Usuario;

public interface IUsuarioService {

	public List<Usuario> listarUsuario(); 
	
	public Usuario guardarUsuario(Usuario Usuario);	
	
	public Usuario UsuarioXID(int id);
	
	public Usuario actualizarUsuario(Usuario Usuario); 
	
	public void eliminarUsuario(int id);
	
	
}

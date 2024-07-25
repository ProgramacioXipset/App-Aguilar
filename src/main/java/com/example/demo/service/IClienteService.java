package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Cliente;

public interface IClienteService {

	public List<Cliente> listarCliente(); 
	
	public Cliente guardarCliente(Cliente Cliente);	
	
	public Cliente ClienteXID(int id);
	
	public Cliente actualizarCliente(Cliente Cliente); 
	
	public void eliminarCliente(int id);
	
	
}

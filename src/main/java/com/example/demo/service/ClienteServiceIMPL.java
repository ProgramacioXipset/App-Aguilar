package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IClienteDAO;
import com.example.demo.dto.Cliente;

@Service
public class ClienteServiceIMPL implements IClienteService {
	@Autowired
	IClienteDAO iClienteDAO;
	
	@Override
	public List<Cliente> listarCliente() {
		// TODO Auto-generated method stub
		return iClienteDAO.findAll();
	}

	@Override
	public Cliente guardarCliente(Cliente Cliente) {
		// TODO Auto-generated method stub
		return iClienteDAO.save(Cliente);
	}

	@Override
	public Cliente ClienteXID(int id) {
		// TODO Auto-generated method stub
		return iClienteDAO.findById(id).get();
	}

	@Override
	public Cliente actualizarCliente(Cliente Cliente) {
		// TODO Auto-generated method stub
		return iClienteDAO.save(Cliente);
	}

	@Override
	public void eliminarCliente(int id) {
		// TODO Auto-generated method stub
		iClienteDAO.deleteById(id);
	}

}

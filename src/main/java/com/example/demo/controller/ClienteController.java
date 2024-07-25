package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Cliente;
import com.example.demo.service.ClienteServiceIMPL;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ClienteController {
	
	@Autowired
	ClienteServiceIMPL ClienteServiceImpl;

	@GetMapping("/Cliente")
	public List<Cliente> listarClientes() {
		return ClienteServiceImpl.listarCliente();
	}

	@PostMapping("/Cliente")
	public Cliente salvarCliente(@RequestBody Cliente Cliente) {

		return ClienteServiceImpl.guardarCliente(Cliente);
	}

	@GetMapping("/Cliente/{id}")
	public Cliente ClienteXID(@PathVariable(name = "id") int Codigo) {

		Cliente Cliente_xid = new Cliente();

		Cliente_xid = ClienteServiceImpl.ClienteXID(Codigo);

		return Cliente_xid;
	}

	@PutMapping("/Cliente/{id}")
	public Cliente actualizarCliente(@PathVariable(name = "id") int Codigo, @RequestBody Cliente Cliente) {

		Cliente Cliente_seleccionado = new Cliente();
		Cliente Cliente_actualizado = new Cliente();

		Cliente_seleccionado = ClienteServiceImpl.ClienteXID(Codigo);

		Cliente_seleccionado.setId(Cliente.getId());
		Cliente_seleccionado.setNombre(Cliente.getNombre());
		Cliente_seleccionado.setDireccion(Cliente.getDireccion());

		Cliente_actualizado = ClienteServiceImpl.actualizarCliente(Cliente_seleccionado);

		return Cliente_actualizado;
	}

	@DeleteMapping("/Cliente/{id}")
	public void eliminarCliente(@PathVariable(name = "id") int Codigo) {
		ClienteServiceImpl.eliminarCliente(Codigo);
	}
}

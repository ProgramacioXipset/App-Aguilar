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

import com.example.demo.dto.XoferNoDisponible;
import com.example.demo.service.XoferNoDisponibleServiceIMPL;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class XoferNoDisponibleController {
	@Autowired
	XoferNoDisponibleServiceIMPL XoferNoDisponibleServiceImpl;

	@GetMapping("/XoferNoDisponible/Xofer/{id}")
	public List<XoferNoDisponible> listarXoferNoDisponiblesPerXofer(@PathVariable(name = "id") int Codigo) {
		return XoferNoDisponibleServiceImpl.findByXofer(Codigo);
	}
	
	@DeleteMapping("/XoferNoDisponible/Xofer/{id}")
	public void eliminarXoferNoDisponiblesPerXofer(@PathVariable(name = "id") int Codigo) {
		XoferNoDisponibleServiceImpl.deleteByXofer(Codigo);
	}
	
	@GetMapping("/XoferNoDisponible")
	public List<XoferNoDisponible> listarXoferNoDisponibles() {
		return XoferNoDisponibleServiceImpl.listarXoferNoDisponible();
	}

	@PostMapping("/XoferNoDisponible")
	public XoferNoDisponible salvarXoferNoDisponible(@RequestBody XoferNoDisponible XoferNoDisponible) {

		return XoferNoDisponibleServiceImpl.guardarXoferNoDisponible(XoferNoDisponible);
	}

	@GetMapping("/XoferNoDisponible/{id}")
	public XoferNoDisponible XoferNoDisponibleXID(@PathVariable(name = "id") int Codigo) {

		XoferNoDisponible XoferNoDisponible_xid = new XoferNoDisponible();

		XoferNoDisponible_xid = XoferNoDisponibleServiceImpl.XoferNoDisponibleXID(Codigo);

		return XoferNoDisponible_xid;
	}

	@PutMapping("/XoferNoDisponible/{id}")
	public XoferNoDisponible actualizarXoferNoDisponible(@PathVariable(name = "id") int Codigo, @RequestBody XoferNoDisponible XoferNoDisponible) {

		XoferNoDisponible XoferNoDisponible_seleccionado = new XoferNoDisponible();
		XoferNoDisponible XoferNoDisponible_actualizado = new XoferNoDisponible();

		XoferNoDisponible_seleccionado = XoferNoDisponibleServiceImpl.XoferNoDisponibleXID(Codigo);

		XoferNoDisponible_seleccionado.setId(XoferNoDisponible.getId());
		XoferNoDisponible_seleccionado.setId_xofer(XoferNoDisponible.getId_xofer());
		XoferNoDisponible_seleccionado.setDia(XoferNoDisponible.getDia());

		XoferNoDisponible_actualizado = XoferNoDisponibleServiceImpl.actualizarXoferNoDisponible(XoferNoDisponible_seleccionado);

		return XoferNoDisponible_actualizado;
	}

	@DeleteMapping("/XoferNoDisponible/{id}")
	public void eliminarXoferNoDisponible(@PathVariable(name = "id") int Codigo) {
		XoferNoDisponibleServiceImpl.eliminarXoferNoDisponible(Codigo);
	}
}

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

import com.example.demo.dto.Icones;
import com.example.demo.service.IconesServiceIMPL;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class IconesController {

	@Autowired
	IconesServiceIMPL IconesServiceImpl;

	@GetMapping("/Icones")
	public List<Icones> listarIcones() {
		return IconesServiceImpl.listarIcones();
	}

	@PostMapping("/Icones")
	public Icones salvarIcones(@RequestBody Icones Icones) {

		return IconesServiceImpl.guardarIcones(Icones);
	}

	@GetMapping("/Icones/{id}")
	public Icones IconesXID(@PathVariable(name = "id") int Codigo) {

		Icones Icones_xid = new Icones();

		Icones_xid = IconesServiceImpl.IconesXID(Codigo);

		return Icones_xid;

	}

	@PutMapping("/Icones/{id}")
	public Icones actualizarIcones(@PathVariable(name = "id") int Codigo, @RequestBody Icones Icones) {

		Icones Icones_seleccionado = new Icones();
		Icones Icones_actualizado = new Icones();

		Icones_seleccionado = IconesServiceImpl.IconesXID(Codigo);

		Icones_seleccionado.setId(Icones.getId());
		Icones_seleccionado.setIcona(Icones.getIcona());
		Icones_seleccionado.setData(Icones.getData());
		Icones_seleccionado.setId_xofer(Icones.getId_xofer());

		Icones_actualizado = IconesServiceImpl.actualizarIcones(Icones_seleccionado);

		return Icones_actualizado;
	}

	@DeleteMapping("/Icones/{id}")
	public void eliminarIcones(@PathVariable(name = "id") int Codigo) {
		IconesServiceImpl.eliminarIcones(Codigo);
	}
}

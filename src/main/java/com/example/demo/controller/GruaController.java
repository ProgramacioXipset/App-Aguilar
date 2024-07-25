package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.Grua;
import com.example.demo.service.GruaServiceIMPL;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class GruaController {

	@Autowired
	GruaServiceIMPL GruaServiceImpl;

	@GetMapping("/Grua")
	public List<Grua> listarGruas() {
		return GruaServiceImpl.listarGrua();
	}

	@PostMapping("/Grua")
	public Grua salvarGrua(@RequestBody Grua Grua) {

		return GruaServiceImpl.guardarGrua(Grua);
	}

	@GetMapping("/Grua/{id}")
	public Grua GruaXID(@PathVariable(name = "id") int Codigo) {

		Grua Grua_xid = new Grua();

		Grua_xid = GruaServiceImpl.GruaXID(Codigo);

		return Grua_xid;

	}

	@PutMapping("/Grua/{id}")
	public Grua actualizarGrua(@PathVariable(name = "id") int Codigo, @RequestBody Grua Grua) {

		Grua Grua_seleccionado = new Grua();
		Grua Grua_actualizado = new Grua();

		Grua_seleccionado = GruaServiceImpl.GruaXID(Codigo);

		Grua_seleccionado.setId(Grua.getId());
		Grua_seleccionado.setNombre(Grua.getNombre());

		Grua_actualizado = GruaServiceImpl.actualizarGrua(Grua_seleccionado);

		return Grua_actualizado;
	}

	@DeleteMapping("/Grua/{id}")
	public void eliminarGrua(@PathVariable(name = "id") int Codigo) {
		GruaServiceImpl.eliminarGrua(Codigo);
	}
}

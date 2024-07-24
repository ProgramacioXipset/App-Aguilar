package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.Camio;
import com.example.demo.service.CamioServiceIMPL;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CamioController {

	@Autowired
	CamioServiceIMPL CamioServiceImpl;

	@GetMapping("/Camio")
	public List<Camio> listarCamios() {
		return CamioServiceImpl.listarCamio();
	}

	@PostMapping("/Camio")
	public Camio salvarCamio(@RequestBody Camio Camio) {

		return CamioServiceImpl.guardarCamio(Camio);
	}

	@GetMapping("/Camio/{id}")
	public Camio CamioXID(@PathVariable(name = "id") int Codigo) {

		Camio Camio_xid = new Camio();

		Camio_xid = CamioServiceImpl.CamioXID(Codigo);

		return Camio_xid;

	}

	@PutMapping("/Camio/{id}")
	public Camio actualizarCamio(@PathVariable(name = "id") int Codigo, @RequestBody Camio Camio) {

		Camio Camio_seleccionado = new Camio();
		Camio Camio_actualizado = new Camio();

		Camio_seleccionado = CamioServiceImpl.CamioXID(Codigo);

		Camio_seleccionado.setId(Camio.getId());
		Camio_seleccionado.setMatricula(Camio.getMatricula());
		Camio_seleccionado.setMarca_model(Camio.getMarca_model());

		Camio_actualizado = CamioServiceImpl.actualizarCamio(Camio_seleccionado);

		return Camio_actualizado;
	}

	@DeleteMapping("/Camio/{id}")
	public void eliminarCamio(@PathVariable(name = "id") int Codigo) {
		CamioServiceImpl.eliminarCamio(Codigo);
	}
}

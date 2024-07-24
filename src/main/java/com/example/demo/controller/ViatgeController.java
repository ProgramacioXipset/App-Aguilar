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

import com.example.demo.dto.Viatge;
import com.example.demo.service.ViatgeServiceIMPL;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ViatgeController {
	@Autowired
	ViatgeServiceIMPL ViatgeServiceImpl;

	@GetMapping("/AvuiXAvui")
	public List<Viatge> listarAvuiXAvuis() {
		return ViatgeServiceImpl.listarAvuiXAvui();
	}
	
	@GetMapping("/Anada")
	public List<Viatge> listarAnades() {
		return ViatgeServiceImpl.listarAnada();
	}
	
	@GetMapping("/Tornada")
	public List<Viatge> listarTornades() {
		return ViatgeServiceImpl.listarTornada();
	}
	
	@GetMapping("/Viatge")
	public List<Viatge> listarViatges() {
		return ViatgeServiceImpl.listarViatge();
	}

	@PostMapping("/Viatge")
	public Viatge salvarViatge(@RequestBody Viatge Viatge) {

		return ViatgeServiceImpl.guardarViatge(Viatge);
	}

	@GetMapping("/Viatge/{id}")
	public Viatge ViatgeXID(@PathVariable(name = "id") int Codigo) {

		Viatge Viatge_xid = new Viatge();

		Viatge_xid = ViatgeServiceImpl.ViatgeXID(Codigo);

		return Viatge_xid;
	}

	@PutMapping("/Viatge/{id}")
	public Viatge actualizarViatge(@PathVariable(name = "id") int Codigo, @RequestBody Viatge Viatge) {

		Viatge Viatge_seleccionado = new Viatge();
		Viatge Viatge_actualizado = new Viatge();

		Viatge_seleccionado = ViatgeServiceImpl.ViatgeXID(Codigo);

		Viatge_seleccionado.setId(Viatge.getId());
		Viatge_seleccionado.setId_direccio_origen(Viatge.getId_direccio_origen());
		Viatge_seleccionado.setId_direccio_desti(Viatge.getId_direccio_desti());
		Viatge_seleccionado.setComentari(Viatge.getComentari());
		Viatge_seleccionado.setDia(Viatge.getDia());
		Viatge_seleccionado.setId_ruta(Viatge.getId_ruta());
		Viatge_seleccionado.setExterna(Viatge.getExterna());
		Viatge_seleccionado.setTipus(Viatge.getTipus());
		Viatge_seleccionado.setData_inicial(Viatge.getData_inicial());
		Viatge_seleccionado.setN_comanda(Viatge.getN_comanda());
		Viatge_seleccionado.setAmagat(Viatge.getAmagat());
		Viatge_seleccionado.setDividit(Viatge.getDividit());
		Viatge_seleccionado.setOrdre(Viatge.getOrdre());

		Viatge_actualizado = ViatgeServiceImpl.actualizarViatge(Viatge_seleccionado);

		return Viatge_actualizado;
	}

	@DeleteMapping("/Viatge/{id}")
	public void eliminarViatge(@PathVariable(name = "id") int Codigo) {
		ViatgeServiceImpl.eliminarViatge(Codigo);
	}
}

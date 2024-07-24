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

import com.example.demo.dto.CamioNoDisponible;
import com.example.demo.service.CamioNoDisponibleServiceIMPL;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CamioNoDisponibleController {
	
	@Autowired
	CamioNoDisponibleServiceIMPL CamioNoDisponibleServiceImpl;

	@GetMapping("/CamioNoDisponible/Camio/{id}")
	public List<CamioNoDisponible> listarCamioNoDisponiblesPerCamio(@PathVariable(name = "id") int Codigo) {
		return CamioNoDisponibleServiceImpl.findByCamio(Codigo);
	}
	
	@DeleteMapping("/CamioNoDisponible/Camio/{id}")
	public void eliminarCamioNoDisponiblesPerCamio(@PathVariable(name = "id") int Codigo) {
		CamioNoDisponibleServiceImpl.deleteByCamio(Codigo);
	}
	
	@GetMapping("/CamioNoDisponible")
	public List<CamioNoDisponible> listarCamioNoDisponibles() {
		return CamioNoDisponibleServiceImpl.listarCamioNoDisponible();
	}

	@PostMapping("/CamioNoDisponible")
	public CamioNoDisponible salvarCamioNoDisponible(@RequestBody CamioNoDisponible CamioNoDisponible) {

		return CamioNoDisponibleServiceImpl.guardarCamioNoDisponible(CamioNoDisponible);
	}

	@GetMapping("/CamioNoDisponible/{id}")
	public CamioNoDisponible CamioNoDisponibleXID(@PathVariable(name = "id") int Codigo) {

		CamioNoDisponible CamioNoDisponible_xid = new CamioNoDisponible();

		CamioNoDisponible_xid = CamioNoDisponibleServiceImpl.CamioNoDisponibleXID(Codigo);

		return CamioNoDisponible_xid;
	}

	@PutMapping("/CamioNoDisponible/{id}")
	public CamioNoDisponible actualizarCamioNoDisponible(@PathVariable(name = "id") int Codigo, @RequestBody CamioNoDisponible CamioNoDisponible) {

		CamioNoDisponible CamioNoDisponible_seleccionado = new CamioNoDisponible();
		CamioNoDisponible CamioNoDisponible_actualizado = new CamioNoDisponible();

		CamioNoDisponible_seleccionado = CamioNoDisponibleServiceImpl.CamioNoDisponibleXID(Codigo);

		CamioNoDisponible_seleccionado.setId(CamioNoDisponible.getId());
		CamioNoDisponible_seleccionado.setCamio(CamioNoDisponible.getCamio());
		CamioNoDisponible_seleccionado.setDia(CamioNoDisponible.getDia());

		CamioNoDisponible_actualizado = CamioNoDisponibleServiceImpl.actualizarCamioNoDisponible(CamioNoDisponible_seleccionado);

		return CamioNoDisponible_actualizado;
	}

	@DeleteMapping("/CamioNoDisponible/{id}")
	public void eliminarCamioNoDisponible(@PathVariable(name = "id") int Codigo) {
		CamioNoDisponibleServiceImpl.eliminarCamioNoDisponible(Codigo);
	}
}

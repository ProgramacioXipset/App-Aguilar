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

import com.example.demo.dto.RemolcNoDisponible;
import com.example.demo.service.RemolcNoDisponibleServiceIMPL;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class RemolcNoDisponibleController {
	@Autowired
	RemolcNoDisponibleServiceIMPL RemolcNoDisponibleServiceImpl;
	
	@GetMapping("/RemolcNoDisponible/Remolc/{id}")
	public List<RemolcNoDisponible> listarRemolcNoDisponibleRemolc(@PathVariable(name = "id") int Codigo) {
		return RemolcNoDisponibleServiceImpl.findByRemolc(Codigo);
	}
	
	@DeleteMapping("/RemolcNoDisponible/Remolc/{id}")
	public void eliminarCamioNoDisponiblesPerCamio(@PathVariable(name = "id") int Codigo) {
		RemolcNoDisponibleServiceImpl.deleteByRemolc(Codigo);
	}
	
	@GetMapping("/RemolcNoDisponible")
	public List<RemolcNoDisponible> listarRemolcNoDisponibles() {
		return RemolcNoDisponibleServiceImpl.listarRemolcNoDisponible();
	}

	@PostMapping("/RemolcNoDisponible")
	public RemolcNoDisponible salvarRemolcNoDisponible(@RequestBody RemolcNoDisponible RemolcNoDisponible) {

		return RemolcNoDisponibleServiceImpl.guardarRemolcNoDisponible(RemolcNoDisponible);
	}

	@GetMapping("/RemolcNoDisponible/{id}")
	public RemolcNoDisponible RemolcNoDisponibleXID(@PathVariable(name = "id") int Codigo) {

		RemolcNoDisponible RemolcNoDisponible_xid = new RemolcNoDisponible();

		RemolcNoDisponible_xid = RemolcNoDisponibleServiceImpl.RemolcNoDisponibleXID(Codigo);

		return RemolcNoDisponible_xid;
	}

	@PutMapping("/RemolcNoDisponible/{id}")
	public RemolcNoDisponible actualizarRemolcNoDisponible(@PathVariable(name = "id") int Codigo, @RequestBody RemolcNoDisponible RemolcNoDisponible) {

		RemolcNoDisponible RemolcNoDisponible_seleccionado = new RemolcNoDisponible();
		RemolcNoDisponible RemolcNoDisponible_actualizado = new RemolcNoDisponible();

		RemolcNoDisponible_seleccionado = RemolcNoDisponibleServiceImpl.RemolcNoDisponibleXID(Codigo);

		RemolcNoDisponible_seleccionado.setId(RemolcNoDisponible.getId());
		RemolcNoDisponible_seleccionado.setId_remolc(RemolcNoDisponible.getId_remolc());
		RemolcNoDisponible_seleccionado.setDia(RemolcNoDisponible.getDia());

		RemolcNoDisponible_actualizado = RemolcNoDisponibleServiceImpl.actualizarRemolcNoDisponible(RemolcNoDisponible_seleccionado);

		return RemolcNoDisponible_actualizado;
	}

	@DeleteMapping("/RemolcNoDisponible/{id}")
	public void eliminarRemolcNoDisponible(@PathVariable(name = "id") int Codigo) {
		RemolcNoDisponibleServiceImpl.eliminarRemolcNoDisponible(Codigo);
	}
}

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

import com.example.demo.dto.Xofer;
import com.example.demo.service.XoferServiceIMPL;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class XoferController {
	
	@Autowired
	XoferServiceIMPL XoferServiceImpl;

	@GetMapping("/Xofer")
	public List<Xofer> listarXofers() {
		return XoferServiceImpl.listarXofer();
	}

	@PostMapping("/Xofer")
	public Xofer salvarXofer(@RequestBody Xofer Xofer) {

		return XoferServiceImpl.guardarXofer(Xofer);
	}

	@GetMapping("/Xofer/{id}")
	public Xofer XoferXID(@PathVariable(name = "id") int Codigo) {

		Xofer Xofer_xid = new Xofer();

		Xofer_xid = XoferServiceImpl.XoferXID(Codigo);

		return Xofer_xid;
	}

	@PutMapping("/Xofer/{id}")
	public Xofer actualizarXofer(@PathVariable(name = "id") int Codigo, @RequestBody Xofer Xofer) {

		Xofer Xofer_seleccionado = new Xofer();
		Xofer Xofer_actualizado = new Xofer();

		Xofer_seleccionado = XoferServiceImpl.XoferXID(Codigo);

		Xofer_seleccionado.setId(Xofer.getId());
		Xofer_seleccionado.setNom(Xofer.getNom());
		Xofer_seleccionado.setCognoms(Xofer.getCognoms());
		Xofer_seleccionado.setTelefon(Xofer.getTelefon());
		Xofer_seleccionado.setDni(Xofer.getDni());
		Xofer_seleccionado.setId_camio(Xofer.getId_camio());
		Xofer_seleccionado.setId_remolc(Xofer.getId_remolc());
		Xofer_seleccionado.setOrdre(Xofer.getOrdre());
		Xofer_seleccionado.setSeparador(Xofer.getSeparador());

		Xofer_actualizado = XoferServiceImpl.actualizarXofer(Xofer_seleccionado);

		return Xofer_actualizado;
	}

	@DeleteMapping("/Xofer/{id}")
	public void eliminarXofer(@PathVariable(name = "id") int Codigo) {
		XoferServiceImpl.eliminarXofer(Codigo);
	}
}

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

import com.example.demo.dto.Direccio;
import com.example.demo.service.DireccioServiceIMPL;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class DireccioController {

	@Autowired
	DireccioServiceIMPL DireccioServiceImpl;

	@GetMapping("/Direccio")
	public List<Direccio> listarDireccios() {
		return DireccioServiceImpl.listarDireccio();
	}

	@PostMapping("/Direccio")
	public Direccio salvarDireccio(@RequestBody Direccio Direccio) {

		return DireccioServiceImpl.guardarDireccio(Direccio);
	}

	@GetMapping("/Direccio/{id}")
	public Direccio DireccioXID(@PathVariable(name = "id") int Codigo) {

		Direccio Direccio_xid = new Direccio();

		Direccio_xid = DireccioServiceImpl.DireccioXID(Codigo);

		return Direccio_xid;
	}

	@PutMapping("/Direccio/{id}")
	public Direccio actualizarDireccio(@PathVariable(name = "id") int Codigo, @RequestBody Direccio Direccio) {

		Direccio Direccio_seleccionado = new Direccio();
		Direccio Direccio_actualizado = new Direccio();

		Direccio_seleccionado = DireccioServiceImpl.DireccioXID(Codigo);

		Direccio_seleccionado.setId(Direccio.getId());
		Direccio_seleccionado.setAdreca(Direccio.getAdreca());
		Direccio_seleccionado.setPoblacio(Direccio.getPoblacio());
		Direccio_seleccionado.setCodi_postal(Direccio.getCodi_postal());

		Direccio_actualizado = DireccioServiceImpl.actualizarDireccio(Direccio_seleccionado);

		return Direccio_actualizado;
	}

	@DeleteMapping("/Direccio/{id}")
	public void eliminarDireccio(@PathVariable(name = "id") int Codigo) {
		DireccioServiceImpl.eliminarDireccio(Codigo);
	}
	
}

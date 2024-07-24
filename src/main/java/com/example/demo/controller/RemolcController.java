package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.Remolc;
import com.example.demo.service.RemolcServiceIMPL;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class RemolcController {

	@Autowired
	RemolcServiceIMPL RemolcServiceImpl;

	@GetMapping("/Remolc")
	public List<Remolc> listarRemolcs() {
		return RemolcServiceImpl.listarRemolc();
	}

	@PostMapping("/Remolc")
	public Remolc salvarRemolc(@RequestBody Remolc Remolc) {

		return RemolcServiceImpl.guardarRemolc(Remolc);
	}

	@GetMapping("/Remolc/{id}")
	public Remolc RemolcXID(@PathVariable(name = "id") int Codigo) {

		Remolc Remolc_xid = new Remolc();

		Remolc_xid = RemolcServiceImpl.RemolcXID(Codigo);

		return Remolc_xid;

	}

	@PutMapping("/Remolc/{id}")
	public Remolc actualizarRemolc(@PathVariable(name = "id") int Codigo, @RequestBody Remolc Remolc) {

		Remolc Remolc_seleccionado = new Remolc();
		Remolc Remolc_actualizado = new Remolc();

		Remolc_seleccionado = RemolcServiceImpl.RemolcXID(Codigo);

		Remolc_seleccionado.setId(Remolc.getId());
		Remolc_seleccionado.setMatricula(Remolc.getMatricula());
		
		Remolc_actualizado = RemolcServiceImpl.actualizarRemolc(Remolc_seleccionado);

		return Remolc_actualizado;
	}

	@DeleteMapping("/Remolc/{id}")
	public void eliminarRemolc(@PathVariable(name = "id") int Codigo) {
		RemolcServiceImpl.eliminarRemolc(Codigo);
	}
}

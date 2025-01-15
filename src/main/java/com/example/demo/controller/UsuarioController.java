package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.IUsuarioDAO;
import com.example.demo.dto.Usuario;
import com.example.demo.service.UsuarioServiceIMPL;
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UsuarioController {

	@Autowired
	UsuarioServiceIMPL UsuarioServiceImpl;
	
	private IUsuarioDAO iUsuarioDAO;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UsuarioController(IUsuarioDAO iUsuarioDAO, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.iUsuarioDAO = iUsuarioDAO;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@GetMapping("/response-entity-builder-with-http-headers")
	public ResponseEntity<String> usingResponseEntityBuilderAndHttpHeaders() {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Baeldun-Header","Value-ResponseEntityBuilderWithHttpHeaders");
		
		return ResponseEntity.ok()
				.headers(responseHeaders)
				.body("Response with header using ResponseEntity");
	}
	
	@PostMapping("/users/")
	public Usuario saveUsuario(@RequestBody Usuario user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		iUsuarioDAO.save(user);
		return user;
	}
	
	@GetMapping("/users/")
	public List<Usuario> getAllUsuarios() {
		return iUsuarioDAO.findAll();
	}
	
	@GetMapping("/users/{username}")
	public Usuario getUsuario(@PathVariable String username) {
		return iUsuarioDAO.findByUsername(username);
	}
	
	@PutMapping("/users/{id}")
	public Usuario actualizarUsuario(@PathVariable(name = "id") int Codigo, @RequestBody Usuario Usuario) {

		Usuario Usuario_seleccionado = new Usuario();
		Usuario Usuario_actualizado = new Usuario();

		Usuario_seleccionado = iUsuarioDAO.findById(Codigo).get();

		Usuario_seleccionado.setId(Usuario.getId());
		Usuario_seleccionado.setUsername(Usuario.getUsername());
		Usuario_seleccionado.setApellidos(Usuario.getApellidos());
		Usuario_seleccionado.setPassword(Usuario_seleccionado.getPassword());
		Usuario_seleccionado.setEmail(Usuario.getEmail());
		Usuario_seleccionado.setRol(Usuario.getRol());

		Usuario_actualizado = UsuarioServiceImpl.actualizarUsuario(Usuario_seleccionado);

		return Usuario_actualizado;
	}

	@PutMapping("/users/pass/{id}")
	public Usuario actualizarPassUsuario(@PathVariable(name = "id") int Codigo, @RequestBody Usuario Usuario) {

		Usuario Usuario_seleccionado = new Usuario();
		Usuario Usuario_actualizado = new Usuario();

		Usuario_seleccionado = iUsuarioDAO.findById(Codigo).get();

		Usuario_seleccionado.setId(Usuario_seleccionado.getId());
		Usuario_seleccionado.setUsername(Usuario_seleccionado.getUsername());
		Usuario_seleccionado.setApellidos(Usuario_seleccionado.getApellidos());
		Usuario_seleccionado.setPassword(bCryptPasswordEncoder.encode(Usuario.getPassword()));
		Usuario_seleccionado.setEmail(Usuario_seleccionado.getEmail());
		Usuario_seleccionado.setRol(Usuario_seleccionado.getRol());

		Usuario_actualizado = UsuarioServiceImpl.actualizarUsuario(Usuario_seleccionado);

		return Usuario_actualizado;
	}
	
	@DeleteMapping("/users/{id}")
	public String eliminarUser(@PathVariable(name="id")int id) {
		iUsuarioDAO.deleteById(id);
		return "User deleted.";
	}
}

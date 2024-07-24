package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.IUsuariDAO;
import com.example.demo.dto.Usuari;
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UsuariController {

	private IUsuariDAO iUsuariDAO;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UsuariController(IUsuariDAO iUsuariDAO, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.iUsuariDAO = iUsuariDAO;
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
	public Usuari saveUsuari(@RequestBody Usuari user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		iUsuariDAO.save(user);
		return user;
	}
	
	@GetMapping("/users/")
	public List<Usuari> getAllUsuaris() {
		return iUsuariDAO.findAll();
	}
	
	@GetMapping("/users/{username}")
	public Usuari getUsuari(@PathVariable String username) {
		return iUsuariDAO.findByUsername(username);
	}
	
	@DeleteMapping("/users/{id}")
	public String eliminarUser(@PathVariable(name="id")int id) {
		iUsuariDAO.deleteById(id);
		return "User deleted.";
	}
	
}

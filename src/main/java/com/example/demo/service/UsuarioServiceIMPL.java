package com.example.demo.service;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IUsuarioDAO;
import com.example.demo.dto.Cliente;
import com.example.demo.dto.Usuario;

@Service
public class UsuarioServiceIMPL implements UserDetailsService {
	private IUsuarioDAO iUsuarioDAO;
	
	public UsuarioServiceIMPL(IUsuarioDAO iUsuarioDAO) {
		this.iUsuarioDAO = iUsuarioDAO;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario Usuario = iUsuarioDAO.findByUsername(username);
		if (Usuario == null) {
			throw new UsernameNotFoundException(username);
		}
		return new User(Usuario.getUsername(), Usuario.getPassword(), AuthorityUtils.createAuthorityList(Usuario.getRol()));
	}
	
	public Usuario actualizarUsuario(Usuario Usuario) {
		return iUsuarioDAO.save(Usuario);
	}
}

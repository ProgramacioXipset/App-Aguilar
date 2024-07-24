package com.example.demo.service;

import static java.util.Collections.emptyList;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IUsuariDAO;
import com.example.demo.dto.Usuari;

@Service
public class UsuariServiceIMPL implements UserDetailsService {
	private IUsuariDAO iUsuariDAO;
	
	public UsuariServiceIMPL(IUsuariDAO iUsuariDAO) {
		this.iUsuariDAO = iUsuariDAO;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuari Usuari = iUsuariDAO.findByUsername(username);
		if (Usuari == null) {
			throw new UsernameNotFoundException(username);
		}
		return new User(Usuari.getUsername(), Usuari.getPassword(), AuthorityUtils.createAuthorityList(Usuari.getRol()));
	}

}

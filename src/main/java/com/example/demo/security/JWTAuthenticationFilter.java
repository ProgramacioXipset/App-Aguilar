package com.example.demo.security;

import static com.example.demo.security.Constants.HEADER_AUTHORIZACION_KEY;
import static com.example.demo.security.Constants.ISSUER_INFO;
import static com.example.demo.security.Constants.SUPER_SECRET_KEY;
import static com.example.demo.security.Constants.TOKEN_BEARER_PREFIX;
import static com.example.demo.security.Constants.TOKEN_EXPIRATION_TIME;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.dto.Usuari;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	
	private AuthenticationManager authenticationManager;
	
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
			try {
				Usuari cred = new ObjectMapper().readValue(request.getInputStream(), Usuari.class);
				return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
						cred.getUsername(), cred.getPassword(), new ArrayList<>()));
			} catch(IOException e) {
				throw new RuntimeException(e);
		} 

		
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication auth) throws IOException, ServletException {

	    // Obtener el rol del usuario autenticado
	    String role = auth.getAuthorities().stream()
	                    .findFirst()
	                    .map(GrantedAuthority::getAuthority)
	                    .orElse("");
	    
	    System.out.println("Roles del usuario: " + auth.getAuthorities()); // Agregar este registro de depuración
		
		String token = Jwts.builder()
				.setIssuedAt(new Date())
				.setIssuer(ISSUER_INFO)
				.setSubject(((User)auth.getPrincipal()).getUsername())
				 .claim("role", role) // Añadir el rol como una claim al token
				.setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SUPER_SECRET_KEY)
				.compact();
		
	    // Devolver el token y el rol en el cuerpo de la respuesta
	    response.addHeader(HEADER_AUTHORIZACION_KEY, TOKEN_BEARER_PREFIX + " " + token);
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write("{\"token\": \"" + token + "\"}");
	    System.out.println(response.getHeader(HEADER_AUTHORIZACION_KEY));
	
	}
	
}
	
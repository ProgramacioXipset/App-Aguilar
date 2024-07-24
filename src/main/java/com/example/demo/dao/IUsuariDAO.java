package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Usuari;


public interface IUsuariDAO extends JpaRepository<Usuari, Integer> {

	Usuari findByUsername(String username);
}

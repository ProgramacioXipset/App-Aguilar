package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Cliente;


public interface IClienteDAO extends JpaRepository<Cliente, Integer> {

}

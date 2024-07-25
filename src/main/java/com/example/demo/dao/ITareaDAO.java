package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Tarea;

public interface ITareaDAO extends JpaRepository<Tarea, Integer>{

	
}

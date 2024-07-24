package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.dto.Viatge;

public interface IViatgeDAO extends JpaRepository<Viatge, Integer>{
	
    @Query("SELECT t FROM Viatge t WHERE t.tipus = 1")
    List<Viatge> findByAvuiXAvui();
    
    @Query("SELECT t FROM Viatge t WHERE t.tipus = 2")
    List<Viatge> findByAnada();
    
    @Query("SELECT t FROM Viatge t WHERE t.tipus = 3")
    List<Viatge> findByTornada();
	
}

package com.example.demo.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.dto.Tarea;

public interface ITareaDAO extends JpaRepository<Tarea, Integer>{

	@Query("SELECT t FROM Tarea t WHERE t.grua.id = :gruaId AND " +
	           "(t.fecha_inicio < :fin AND t.fecha_final > :inicio)")
	List<Tarea> findOverlappingTareas(@Param("gruaId") int gruaId,
	                                  @Param("inicio") LocalDateTime inicio,
	                                  @Param("fin") LocalDateTime fin);
	
}

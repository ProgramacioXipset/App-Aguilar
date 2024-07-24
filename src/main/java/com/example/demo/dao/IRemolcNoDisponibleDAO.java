package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.RemolcNoDisponible;

public interface IRemolcNoDisponibleDAO extends JpaRepository<RemolcNoDisponible, Integer>{

	@Query("SELECT t FROM RemolcNoDisponible t WHERE t.id_remolc.id = :parametro")
    List<RemolcNoDisponible> findByRemolc(@Param("parametro") int valorParametro);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM RemolcNoDisponible t WHERE t.id_remolc.id = :parametro")
	void deleteByRemolc(@Param("parametro") int valorParametro);
	
}

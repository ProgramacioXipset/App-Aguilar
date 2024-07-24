package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.XoferNoDisponible;

public interface IXoferNoDisponibleDAO extends JpaRepository<XoferNoDisponible, Integer>{
    
	@Query("SELECT t FROM XoferNoDisponible t WHERE t.id_xofer.id = :parametro")
    List<XoferNoDisponible> findByXofer(@Param("parametro") int valorParametro);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM XoferNoDisponible t WHERE t.id_xofer.id = :parametro")
	void deleteByXofer(@Param("parametro") int valorParametro);
	
}
 
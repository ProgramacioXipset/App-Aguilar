package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.CamioNoDisponible;

public interface ICamioNoDisponibleDAO extends JpaRepository<CamioNoDisponible, Integer>{

	@Query("SELECT t FROM CamioNoDisponible t WHERE t.id_camio.id = :parametro")
    List<CamioNoDisponible> findByCamio(@Param("parametro") int valorParametro);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM CamioNoDisponible t WHERE t.id_camio.id = :parametro")
	void deleteByCamio(@Param("parametro") int valorParametro);
	
}

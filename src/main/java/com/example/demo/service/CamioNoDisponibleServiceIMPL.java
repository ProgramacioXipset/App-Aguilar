package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ICamioNoDisponibleDAO;
import com.example.demo.dto.CamioNoDisponible;

@Service
public class CamioNoDisponibleServiceIMPL implements ICamioNoDisponibleService {

	@Autowired
	ICamioNoDisponibleDAO iCamioNoDisponibleDAO;
	
	@Override
	public List<CamioNoDisponible> listarCamioNoDisponible() {
		return iCamioNoDisponibleDAO.findAll();
	}

	@Override
	public CamioNoDisponible guardarCamioNoDisponible(CamioNoDisponible CamioNoDisponible) {
		return iCamioNoDisponibleDAO.save(CamioNoDisponible);
	}

	@Override
	public CamioNoDisponible CamioNoDisponibleXID(int id) {
		return iCamioNoDisponibleDAO.findById(id).get();
	}

	@Override
	public CamioNoDisponible actualizarCamioNoDisponible(CamioNoDisponible CamioNoDisponible) {
		return iCamioNoDisponibleDAO.save(CamioNoDisponible);
	}

	@Override
	public void eliminarCamioNoDisponible(int id) {
		iCamioNoDisponibleDAO.deleteById(id);
	}

	@Override
	public List<CamioNoDisponible> findByCamio(int id_camio) {
		// TODO Auto-generated method stub
		return iCamioNoDisponibleDAO.findByCamio(id_camio);
	}

	@Override
	public void deleteByCamio(int id_camio) {
		// TODO Auto-generated method stub
		iCamioNoDisponibleDAO.deleteByCamio(id_camio);
	}

	
	
}

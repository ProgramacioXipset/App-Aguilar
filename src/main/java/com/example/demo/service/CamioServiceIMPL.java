package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ICamioDAO;
import com.example.demo.dto.Camio;

@Service
public class CamioServiceIMPL implements ICamioService {

	@Autowired
	ICamioDAO iCamioDAO;
	
	@Override
	public List<Camio> listarCamio() {
		// TODO Auto-generated method stub
		return iCamioDAO.findAll();
	}

	@Override
	public Camio guardarCamio(Camio Camio) {
		// TODO Auto-generated method stub
		return iCamioDAO.save(Camio);
	}

	@Override
	public Camio CamioXID(int id) {
		// TODO Auto-generated method stub
		return iCamioDAO.findById(id).get();
	}

	@Override
	public Camio actualizarCamio(Camio Camio) {
		// TODO Auto-generated method stub
		return iCamioDAO.save(Camio);
	}

	@Override
	public void eliminarCamio(int id) {
		// TODO Auto-generated method stub
		iCamioDAO.deleteById(id);
	}

	
	
}

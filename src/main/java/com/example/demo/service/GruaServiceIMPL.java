package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IGruaDAO;
import com.example.demo.dto.Grua;

@Service
public class GruaServiceIMPL implements IGruaService {

	@Autowired
	IGruaDAO iGruaDAO;
	
	@Override
	public List<Grua> listarGrua() {
		// TODO Auto-generated method stub
		return iGruaDAO.findAll();
	}

	@Override
	public Grua guardarGrua(Grua Grua) {
		// TODO Auto-generated method stub
		return iGruaDAO.save(Grua);
	}

	@Override
	public Grua GruaXID(int id) {
		// TODO Auto-generated method stub
		return iGruaDAO.findById(id).get();
	}

	@Override
	public Grua actualizarGrua(Grua Grua) {
		// TODO Auto-generated method stub
		return iGruaDAO.save(Grua);
	}

	@Override
	public void eliminarGrua(int id) {
		// TODO Auto-generated method stub
		iGruaDAO.deleteById(id);
	}

	
	
}

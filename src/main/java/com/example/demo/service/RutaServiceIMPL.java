package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IRutaDAO;
import com.example.demo.dto.Ruta;

@Service
public class RutaServiceIMPL implements IRutaService {

	@Autowired
	IRutaDAO iRutaDAO;
	
	@Override
	public List<Ruta> listarRuta() {
		// TODO Auto-generated method stub
		return iRutaDAO.findAll();
	}

	@Override
	public Ruta guardarRuta(Ruta Ruta) {
		// TODO Auto-generated method stub
		return iRutaDAO.save(Ruta);
	}

	@Override
	public Ruta RutaXID(int id) {
		// TODO Auto-generated method stub
		return iRutaDAO.findById(id).get();
	}

	@Override
	public Ruta actualizarRuta(Ruta Ruta) {
		// TODO Auto-generated method stub
		return iRutaDAO.save(Ruta);
	}

	@Override
	public void eliminarRuta(int id) {
		// TODO Auto-generated method stub
		iRutaDAO.deleteById(id);
	}

	
	
}

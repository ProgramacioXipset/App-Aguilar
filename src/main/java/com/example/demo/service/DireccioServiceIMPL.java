package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDireccioDAO;
import com.example.demo.dto.Direccio;

@Service
public class DireccioServiceIMPL implements IDireccioService {

	@Autowired
	IDireccioDAO iDireccioDAO;
	
	@Override
	public List<Direccio> listarDireccio() {
		// TODO Auto-generated method stub
		return iDireccioDAO.findAll();
	}

	@Override
	public Direccio guardarDireccio(Direccio Direccio) {
		// TODO Auto-generated method stub
		return iDireccioDAO.save(Direccio);
	}

	@Override
	public Direccio DireccioXID(int id) {
		// TODO Auto-generated method stub
		return iDireccioDAO.findById(id).get();
	}

	@Override
	public Direccio actualizarDireccio(Direccio Direccio) {
		// TODO Auto-generated method stub
		return iDireccioDAO.save(Direccio);
	}

	@Override
	public void eliminarDireccio(int id) {
		// TODO Auto-generated method stub
		iDireccioDAO.deleteById(id);
	}

	
	
}

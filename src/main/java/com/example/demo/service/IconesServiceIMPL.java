package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IIconesDAO;
import com.example.demo.dto.Icones;

@Service
public class IconesServiceIMPL implements IIconesService {

	@Autowired
	IIconesDAO iIconesDAO;

	@Override
	public List<Icones> listarIcones() {
		// TODO Auto-generated method stub
		return iIconesDAO.findAll();
	}

	@Override
	public Icones guardarIcones(Icones Icones) {
		// TODO Auto-generated method stub
		return iIconesDAO.save(Icones);
	}

	@Override
	public Icones IconesXID(int id) {
		// TODO Auto-generated method stub
		return iIconesDAO.findById(id).get();
	}

	@Override
	public Icones actualizarIcones(Icones Icones) {
		// TODO Auto-generated method stub
		return iIconesDAO.save(Icones);
	}

	@Override
	public void eliminarIcones(int id) {
		// TODO Auto-generated method stub
		iIconesDAO.deleteById(id);
	}
	
}

package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IViatgeDAO;
import com.example.demo.dto.Viatge;

@Service
public class ViatgeServiceIMPL implements IViatgeService {

	@Autowired
	IViatgeDAO iViatgeDAO;
	
	@Override
	public List<Viatge> listarAvuiXAvui() {
		// TODO Auto-generated method stub
		return iViatgeDAO.findByAvuiXAvui();
	}

	@Override
	public List<Viatge> listarAnada() {
		// TODO Auto-generated method stub
		return iViatgeDAO.findByAnada();
	}

	@Override
	public List<Viatge> listarTornada() {
		// TODO Auto-generated method stub
		return iViatgeDAO.findByTornada();
	}
	
	@Override
	public List<Viatge> listarViatge() {
		// TODO Auto-generated method stub
		return iViatgeDAO.findAll();
	}

	@Override
	public Viatge guardarViatge(Viatge Viatge) {
		// TODO Auto-generated method stub
		Viatge viatgeGuardado = iViatgeDAO.save(Viatge);
		viatgeGuardado.setOrdre(viatgeGuardado.getId());
		
		return iViatgeDAO.save(viatgeGuardado);
	}

	@Override
	public Viatge ViatgeXID(int id) {
		// TODO Auto-generated method stub
		return iViatgeDAO.findById(id).get();
	}

	@Override
	public Viatge actualizarViatge(Viatge Viatge) {
		// TODO Auto-generated method stub
		return iViatgeDAO.save(Viatge);
	}

	@Override
	public void eliminarViatge(int id) {
		// TODO Auto-generated method stub
		iViatgeDAO.deleteById(id);
	}


}

package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IRemolcDAO;
import com.example.demo.dto.Remolc;

@Service
public class RemolcServiceIMPL implements IRemolcService {

	@Autowired
	IRemolcDAO iRemolcDAO;
	
	@Override
	public List<Remolc> listarRemolc() {
		// TODO Auto-generated method stub
		return iRemolcDAO.findAll();
	}

	@Override
	public Remolc guardarRemolc(Remolc Remolc) {
		// TODO Auto-generated method stub
		return iRemolcDAO.save(Remolc);
	}

	@Override
	public Remolc RemolcXID(int id) {
		// TODO Auto-generated method stub
		return iRemolcDAO.findById(id).get();
	}

	@Override
	public Remolc actualizarRemolc(Remolc Remolc) {
		// TODO Auto-generated method stub
		return iRemolcDAO.save(Remolc);
	}

	@Override
	public void eliminarRemolc(int id) {
		// TODO Auto-generated method stub
		iRemolcDAO.deleteById(id);
	}

	
	
}

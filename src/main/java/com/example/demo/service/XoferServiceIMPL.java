package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IXoferDAO;
import com.example.demo.dto.Xofer;

@Service
public class XoferServiceIMPL implements IXoferService {
	@Autowired
	IXoferDAO iXoferDAO;
	
	@Override
	public List<Xofer> listarXofer() {
		// TODO Auto-generated method stub
		return iXoferDAO.findAll();
	}

	@Override
	public Xofer guardarXofer(Xofer Xofer) {
		// TODO Auto-generated method stub
		return iXoferDAO.save(Xofer);
	}

	@Override
	public Xofer XoferXID(int id) {
		// TODO Auto-generated method stub
		return iXoferDAO.findById(id).get();
	}

	@Override
	public Xofer actualizarXofer(Xofer Xofer) {
		// TODO Auto-generated method stub
		return iXoferDAO.save(Xofer);
	}

	@Override
	public void eliminarXofer(int id) {
		// TODO Auto-generated method stub
		iXoferDAO.deleteById(id);
	}

}

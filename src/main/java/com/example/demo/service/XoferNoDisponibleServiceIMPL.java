package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IXoferNoDisponibleDAO;
import com.example.demo.dto.XoferNoDisponible;

@Service
public class XoferNoDisponibleServiceIMPL implements IXoferNoDisponibleService {

	@Autowired
	IXoferNoDisponibleDAO iXoferNoDisponibleDAO;
	
	@Override
	public List<XoferNoDisponible> listarXoferNoDisponible() {
		// TODO Auto-generated method stub
		return iXoferNoDisponibleDAO.findAll();
	}

	@Override
	public XoferNoDisponible guardarXoferNoDisponible(XoferNoDisponible XoferNoDisponible) {
		// TODO Auto-generated method stub
		return iXoferNoDisponibleDAO.save(XoferNoDisponible);
	}

	@Override
	public XoferNoDisponible XoferNoDisponibleXID(int id) {
		// TODO Auto-generated method stub
		return iXoferNoDisponibleDAO.findById(id).get();
	}

	@Override
	public XoferNoDisponible actualizarXoferNoDisponible(XoferNoDisponible XoferNoDisponible) {
		// TODO Auto-generated method stub
		return iXoferNoDisponibleDAO.save(XoferNoDisponible);
	}

	@Override
	public void eliminarXoferNoDisponible(int id) {
		// TODO Auto-generated method stub
		iXoferNoDisponibleDAO.deleteById(id);
	}

	@Override
	public List<XoferNoDisponible> findByXofer(int id_xofer) {
		// TODO Auto-generated method stub
		return iXoferNoDisponibleDAO.findByXofer(id_xofer);
	}

	@Override
	public void deleteByXofer(int id_xofer) {
		// TODO Auto-generated method stub
		iXoferNoDisponibleDAO.deleteByXofer(id_xofer);
	}
	
}

package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ITareaDAO;
import com.example.demo.dto.Tarea;

@Service
public class TareaServiceIMPL implements ITareaService {

	@Autowired
	ITareaDAO iTareaDAO;
	
	@Override
	public List<Tarea> listarTarea() {
		// TODO Auto-generated method stub
		return iTareaDAO.findAll();
	}

	@Override
	public Tarea guardarTarea(Tarea Tarea) {
		// TODO Auto-generated method stub
		return iTareaDAO.save(Tarea);
	}

	@Override
	public Tarea TareaXID(int id) {
		// TODO Auto-generated method stub
		return iTareaDAO.findById(id).get();
	}

	@Override
	public Tarea actualizarTarea(Tarea Tarea) {
		// TODO Auto-generated method stub
		return iTareaDAO.save(Tarea);
	}

	@Override
	public void eliminarTarea(int id) {
		// TODO Auto-generated method stub
		iTareaDAO.deleteById(id);
	}


}

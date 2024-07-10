package com.edu.ec.pw.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.ec.pw.api.repository.IMateriaRepository;
import com.edu.ec.pw.api.repository.modelo.Materia;

@Service
public class MateriaServiceImpl implements IMateriaService {
	
	@Autowired
	private IMateriaRepository materiaRepository;

	@Override
	public Materia buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.materiaRepository.seleccionar(id);
	}

	@Override
	public void eliminar(Integer id) {
		this.materiaRepository.borrar(id);
		
	}

	@Override
	public void actualizar(Materia materia) {
		this.materiaRepository.actualizar(materia);
		
	}

	@Override
	public void guardar(Materia materia) {
		this.materiaRepository.insertar(materia);
		
	}
	
	

}

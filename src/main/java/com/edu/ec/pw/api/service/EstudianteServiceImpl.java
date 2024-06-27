package com.edu.ec.pw.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.ec.pw.api.repository.IEstudianteRepository;
import com.edu.ec.pw.api.repository.modelo.Estudiante;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepository estudianteRepository;

	@Override
	public Estudiante seleccionar(Integer id) {
		return this.estudianteRepository.seleccionar(id);

	}

	@Override
	public void actualizar(Estudiante estudiante) {
		this.estudianteRepository.actualizar(estudiante);

	}

	@Override
	public void eliminar(Integer id) {
		this.estudianteRepository.eliminar(id);

	}

	@Override
	public void guardar(Estudiante estudiante) {
		this.estudianteRepository.insertar(estudiante);

	}

}

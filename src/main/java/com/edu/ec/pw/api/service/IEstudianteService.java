package com.edu.ec.pw.api.service;

import java.util.List;

import com.edu.ec.pw.api.repository.modelo.Estudiante;
import com.edu.ec.pw.api.service.to.EstudianteTO;

public interface IEstudianteService {
	
	void guardar(Estudiante estudiante);
	Estudiante buscar(Integer id);
	void actualizar(Estudiante estudiante);
	void borrar(Integer id);
	List<Estudiante> buscarPorGenero(String genero);
	
	public EstudianteTO buscarPorId(Integer id);

}

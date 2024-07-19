package com.edu.ec.pw.api.service;

import java.util.List;

import com.edu.ec.pw.api.repository.modelo.Estudiante;
import com.edu.ec.pw.api.service.to.EstudianteTO;

public interface IEstudianteService {
	
	void guardar(Estudiante estudiante);
	Estudiante buscar(String cedula);
	void actualizar(Estudiante estudiante);
	void borrar(String cedula);
	List<Estudiante> buscarPorGenero(String genero);
	public EstudianteTO buscarPorCedula(String cedula);
	public List<EstudianteTO>buscarTodos();

}

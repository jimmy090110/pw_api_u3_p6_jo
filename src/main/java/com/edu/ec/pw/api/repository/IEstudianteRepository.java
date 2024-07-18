package com.edu.ec.pw.api.repository;

import java.util.List;

import com.edu.ec.pw.api.repository.modelo.Estudiante;

public interface IEstudianteRepository {
	
	void insertar(Estudiante estudiante);
	Estudiante seleccionar(Integer id);
	void actualizar(Estudiante estudiante);
	void eliminar(Integer id);
	
	List<Estudiante>seleccionarPorGenero(String genero);
	List<Estudiante>buscarTodos();
	
	
	

}

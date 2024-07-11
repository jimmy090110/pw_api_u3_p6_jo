package com.edu.ec.pw.api.repository;


import com.edu.ec.pw.api.repository.modelo.Materia;

public interface IMateriaRepository {
	
	Materia seleccionar(Integer id);
	void borrar(Integer id);
	void actualizar(Materia materia);
	void insertar(Materia materia);

}

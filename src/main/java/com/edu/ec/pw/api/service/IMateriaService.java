package com.edu.ec.pw.api.service;

import com.edu.ec.pw.api.repository.modelo.Materia;

public interface IMateriaService {
	
	Materia buscar(Integer id);
	void eliminar(Integer id);
	void actualizar(Materia materia);
	void guardar(Materia materia);

}

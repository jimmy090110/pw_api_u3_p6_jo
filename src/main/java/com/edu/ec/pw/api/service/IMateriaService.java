package com.edu.ec.pw.api.service;

import java.util.List;

import com.edu.ec.pw.api.repository.modelo.Materia;
import com.edu.ec.pw.api.service.to.MateriaTO;

public interface IMateriaService {
	
	Materia buscar(Integer id);
	void eliminar(Integer id);
	void actualizar(Materia materia);
	void guardar(Materia materia);
	 public List<MateriaTO> buscarPorCedulaEstudiante(String cedulaEstudiante);

}

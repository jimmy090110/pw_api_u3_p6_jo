package com.edu.ec.pw.api.service;

import com.edu.ec.pw.api.repository.modelo.Estudiante;

public interface IEstudianteService {
	public  Estudiante seleccionar(Integer id);
	
	public void actualizar(Estudiante estudiante);
	
	public void eliminar(Integer id);
	
	public void guardar(Estudiante estudiante);
	

}




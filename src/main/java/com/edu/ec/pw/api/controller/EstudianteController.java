package com.edu.ec.pw.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edu.ec.pw.api.repository.modelo.Estudiante;
import com.edu.ec.pw.api.service.IEstudianteService;

@RestController
@RequestMapping(path = "/estudiantes")
public class EstudianteController {
	
	@Autowired
	private IEstudianteService estudianteService;

	
	//http://localhost:8080/API/v1.0/Matricula/estudiante/guardar
	//nIVEL 1: //http://localhost:8080/API/v1.0/Matricula/estudiante
	@PostMapping
	public void guardar(@RequestBody Estudiante estudiante) {
		this.estudianteService.guardar(estudiante);
	}
	
	//http://localhost:8080/API/v1.0/Matricula/estudiante/actualizar/
	//Nivel 1 : //http://localhost:8080/API/v1.0/Matricula/estudiante/3
	@PutMapping(path = "/{id}")
	public void actulializar(@RequestBody Estudiante estudiante, @PathVariable Integer id) {
		estudiante.setId(id);
		this.estudianteService.actualizar(estudiante);
	}
	
	//http://localhost:8080/API/v1.0/Matricula/estudiante/actualizar/parcial
	// Nivel 1: http://localhost:8080/API/v1.0/Matricula/estudiantes/{id}
	@PatchMapping(path = "{id}")
	public void actualizarParcial(@RequestBody Estudiante estudiante, @PathVariable Integer id) {
		estudiante.setId(id);
		Estudiante estudiante2=this.estudianteService.buscar(estudiante.getId());
		if(estudiante.getNombre()!=null) {
			estudiante2.setNombre(estudiante.getNombre());
		}if(estudiante.getApellido()!=null) {
			estudiante2.setApellido(estudiante.getNombre());
		}if(estudiante.getFechaNacimiento()!=null) {
			estudiante2.setNombre(estudiante.getNombre());
		}
		this.estudianteService.actualizar(estudiante2);
	}
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/borrar/1
	//Nivel 1: //http://localhost:8080/API/v1.0/Matricula/estudiantes/{id}
	@DeleteMapping(path = "/{id}")
	public void borrar(@PathVariable Integer id) {
		this.estudianteService.borrar(id);
	}
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/buscar/3/nuevo/prueba
	//Nivel 1: //http://localhost:8080/API/v1.0/Matricula/estudiantes/1
	@GetMapping(path = "/{id}")
	public Estudiante buscar(@PathVariable Integer id) {
		return this.estudianteService.buscar(id);
	}
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/buscarPorGenero?genero=F&edad=28
	@GetMapping(path = "/buscarPorGenero")
	public List<Estudiante> buscarPorGenero(@RequestParam String genero,@RequestParam Integer edad) {
		System.out.println("Edad"+edad);
		return this.estudianteService.buscarPorGenero(genero);
	}
	
	//http://localhost:8080/API/v1.0/Matricula/estudiantes/buscarMixto/3?prueba=HolaMundo
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

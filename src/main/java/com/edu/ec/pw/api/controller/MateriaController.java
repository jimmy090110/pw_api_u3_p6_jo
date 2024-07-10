package com.edu.ec.pw.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.ec.pw.api.repository.modelo.Materia;
import com.edu.ec.pw.api.service.IMateriaService;



@RestController
@RequestMapping(path = "/materias")
public class MateriaController {
	
	@Autowired
	private IMateriaService iMateriaService;
	
	//Nivel 1 http://localhost:8082/API/v1.0/Matricula/materias
	@PostMapping
	public ResponseEntity<Materia> agregar(@RequestBody Materia materia) {
		this.iMateriaService.guardar(materia);
		
		return ResponseEntity.status(201).body(materia);
	}
	//Nivel 1 http://localhost:8082/API/v1.0/Matricula/materias/{id}
	@PutMapping(path = "/{id}")
	public ResponseEntity<Materia> modificar(@RequestBody Materia materia,@PathVariable Integer id) {
		 Materia mater = iMateriaService.buscar(id);
	        if (mater != null) {
	            materia.setId(id);
	            iMateriaService.actualizar(materia);
	            
	        }
	        return ResponseEntity.status(238).body(mater);
	}
	//Nivel 1 http://localhost:8082/API/v1.0/Matricula/materias/{id}
	@PatchMapping(path = "/{id}")
	public ResponseEntity<Materia> modificarParcial(@RequestBody Materia materia,@PathVariable Integer id) {
		materia.setId(id);
		Materia materia2=this.iMateriaService.buscar(materia.getId());
		if(materia.getNombre()!=null) {
			materia2.setNombre(materia.getNombre());
		}
		if(materia.getNumeroHoras()!=null) {
			materia2.setNumeroHoras(materia.getNumeroHoras());	
		}
		
		
		this.iMateriaService.actualizar(materia2);
		return ResponseEntity.status(239).body(materia2);
	}
	//Nivel 1 http://localhost:8082/API/v1.0/Matricula/materias
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> borrar(@PathVariable Integer id) {
		this.iMateriaService.eliminar(id);
		return ResponseEntity.status(240).body("Se elimino la materia correctamente");
		
	}
	//Nivel 1 http://localhost:8082/API/v1.0/Matricula/materias/{id}
	@GetMapping(path = "/{id}")
	public Materia encontrar(@PathVariable Integer id) {
		return this.iMateriaService.buscar(id);
		
	}

}

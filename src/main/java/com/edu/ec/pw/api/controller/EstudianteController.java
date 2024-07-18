package com.edu.ec.pw.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import com.edu.ec.pw.api.repository.modelo.Estudiante;
import com.edu.ec.pw.api.service.IEstudianteService;
import com.edu.ec.pw.api.service.IMateriaService;
import com.edu.ec.pw.api.service.to.EstudianteTO;
import com.edu.ec.pw.api.service.to.MateriaTO;

import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
 

@RestController
@RequestMapping(path = "/estudiantes")
//Para pweb solo 5 tipos
public class EstudianteController {

	@Autowired
	private IEstudianteService estudianteService;

	@Autowired
	private IMateriaService materiaService;

	// Post
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/guardar
	// Nivel 1 : http://localhost:8080/API/v1.0/Matricula/estudiantes

	@PostMapping(produces = "application/json", consumes = "application/xml")
	public ResponseEntity<Estudiante> guardar(@RequestBody Estudiante est) {

		this.estudianteService.guardar(est);

		return ResponseEntity.status(HttpStatus.CREATED).body(est);
	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizar
	// Nivel 1 : http://localhost:8080/API/v1.0/Matricula/estudiantes/1
	@PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Estudiante> actualizar(@RequestBody Estudiante est, @PathVariable Integer id) {

		est.setId(id);
		this.estudianteService.actualizar(est);
		return ResponseEntity.status(238).body(est);
	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/actualizarParcial
	// Nivel 1 : http://localhost:8080/API/v1.0/Matricula/estudiantes/1
	@PatchMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Estudiante> actualizarParcial(@RequestBody Estudiante est, @PathVariable Integer id) {
		est.setId(id);
		Estudiante est2 = this.estudianteService.buscar(est.getId());

		if (est.getNombre() != null) {
			est2.setNombre(est.getNombre());
		}
		if (est.getApellido() != null) {
			est2.setApellido(est.getApellido());
		}
		if (est.getFechaNacimiento() != null) {
			est2.setFechaNacimiento(est.getFechaNacimiento());
		}
		this.estudianteService.actualizar(est2);

		return ResponseEntity.status(239).body(est2);

	}

	// delete
//  http://localhost:8080/API/v1.0/Matricula/estudiantes/borrar
// Nivel 1 : http://localhost:8080/API/v1.0/Matricula/estudiantes/1
	@DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> borrar(@PathVariable Integer id) {

		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("Mensaje_240", "Estudiante eliminado");
		cabeceras.add("valor", "Estudiante eliminado");
		this.estudianteService.borrar(id);
		return new ResponseEntity<>(null, cabeceras, 240);

	}

	// Get
	// http://localhost:8080/API/v1.0/Matricula/estudiantes/buscar/1/nuevo/prueba
	// Nivel 1 : http://localhost:8080/API/v1.0/Matricula/estudiantes/1
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Estudiante> buscar(@PathVariable Integer id) {

		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("Mensaje_236", "Corresponde a la consulta de un recurso");
		cabeceras.add("valor", "Estudiante Encontrado");
		return new ResponseEntity<>(this.estudianteService.buscar(id), cabeceras, 236);

		// return ResponseEntity.status(236).body(this.estudianteService.buscar(id));
	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/buscarPorGenero?genero=M&edad=35
	// Nivel 1 : http://localhost:8080/API/v1.0/Matricula/estudiantes/genero
	@GetMapping(path = "/genero", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Estudiante>> buscarPorGenero(@RequestParam String genero) {

		List<Estudiante> ls = this.estudianteService.buscarPorGenero(genero);
		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("Mensaje_237", "Corresponde a la consulta de recursos por género");
		cabeceras.add("valor", "Estudiantes Encontrados");
		return new ResponseEntity<>(ls, cabeceras, 237);

	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/buscarMixto/1?prueba=HolaMundo
	// Nivel 1 : http://localhost:8080/API/v1.0/Matricula/estudiantes/mixto/1
	@GetMapping(path = "/mixto/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Estudiante> buscarMixto(@PathVariable Integer id, @RequestParam String prueba) {
		// System.out.println("Dat : " + id);
		// System.out.println("Dato : " + prueba );

		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("Mensaje_236", "Corresponde a la consulta de un recurso");
		cabeceras.add("valor", "Estudiante Encontrado");
		return new ResponseEntity<>(this.estudianteService.buscar(id), cabeceras, 236);

	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/test/1
	@GetMapping(path = "/test/{id}")
	public Estudiante test(@PathVariable Integer id, @RequestBody Estudiante e) {
		System.out.println(e);
		return this.estudianteService.buscar(id);
	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/texto/plano
	@GetMapping(path = "/texto/plano")
	public String prueba() {
		String prueba = "Texto de prueba";
		return prueba;
	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/hateoas/1
	@GetMapping(path = "/hateoas/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public EstudianteTO buscarHateoas(@PathVariable("id") Integer id) {

		EstudianteTO estudianteTO = this.estudianteService.buscarPorId(id);

		// Error esto es una carga eager
		//List<MateriaTO> ls = this.materiaService.buscarPorIdEstudiante(id);
		//estudianteTO.setMaterias(ls);
		Link myLink =linkTo(methodOn(EstudianteController.class).buscarMateriasPorIdEstudiante(id))
				.withRel("susMaterias");
		estudianteTO.add(myLink);
		
		return estudianteTO;
	}

	// http://localhost:8082/API/v1.0/Matricula/estudiantes/1/materias GET
	@GetMapping(path = "/{id}/materias", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MateriaTO> buscarMateriasPorIdEstudiante(@PathVariable Integer id) {
		return this.materiaService.buscarPorIdEstudiante(id);
	}

}
package com.edu.ec.pw.api.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.edu.ec.pw.api.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements IEstudianteRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Estudiante estudiante) {
		this.entityManager.persist(estudiante);
		
	}

	@Override
	public Estudiante seleccionar(String cedula) {
		Query myQuery= this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.cedula=:cedula",Estudiante.class);
		myQuery.setParameter("cedula", cedula);
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		this.entityManager.merge(estudiante);
		
	}

	@Override
	public void eliminar(String cedula) {
		this.entityManager.remove(this.seleccionar(cedula));
	}

	@Override
	public List<Estudiante> seleccionarPorGenero(String genero) {
		TypedQuery<Estudiante> myQuery= this.entityManager.createQuery("Select e From Estudiante e where e.genero=:genero",Estudiante.class);
		myQuery.setParameter("genero", genero);
		return myQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarTodos() {
		TypedQuery<Estudiante>myQuery= this.entityManager.createQuery("Select e from Estudiante e",Estudiante.class);
		return myQuery.getResultList();
	}

}

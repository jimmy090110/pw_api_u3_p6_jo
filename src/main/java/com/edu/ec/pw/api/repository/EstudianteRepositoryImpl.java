package com.edu.ec.pw.api.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.edu.ec.pw.api.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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
	public Estudiante seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Estudiante.class, id);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		this.entityManager.merge(estudiante);
		
	}

	@Override
	public void eliminar(Integer id) {
		this.entityManager.remove(this.seleccionar(id));
	}

	@Override
	public List<Estudiante> seleccionarPorGenero(String genero) {
		TypedQuery<Estudiante> myQuery= this.entityManager.createQuery("Select e From Estudiante e where e.genero=:genero",Estudiante.class);
		myQuery.setParameter("genero", genero);
		return myQuery.getResultList();
	}

}

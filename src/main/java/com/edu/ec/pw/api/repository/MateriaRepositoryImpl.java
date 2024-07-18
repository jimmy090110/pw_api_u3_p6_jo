package com.edu.ec.pw.api.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.edu.ec.pw.api.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MateriaRepositoryImpl implements IMateriaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Materia seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Materia.class, id);
	}

	@Override
	public void borrar(Integer id) {
		this.entityManager.remove(this.seleccionar(id));
		
	}

	@Override
	public void actualizar(Materia materia) {
		this.entityManager.merge(materia);
		
	}

	@Override
	public void insertar(Materia materia) {
		this.entityManager.persist(materia);
		
	}

	@Override
	public List<Materia> seleccionarPorIdEstudiante(Integer idEstudiante) {
		String jpql = "SELECT m FROM Materia m WHERE m.estudiante.id = :idEstudiante";
		TypedQuery<Materia> myQuery= this.entityManager.createQuery(jpql, Materia.class);
		myQuery.setParameter("idEstudiante", idEstudiante);
		return myQuery.getResultList();
	}

}

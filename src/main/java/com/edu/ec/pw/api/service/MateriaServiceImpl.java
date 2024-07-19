package com.edu.ec.pw.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.ec.pw.api.repository.IMateriaRepository;
import com.edu.ec.pw.api.repository.modelo.Materia;
import com.edu.ec.pw.api.service.to.MateriaTO;

@Service
public class MateriaServiceImpl implements IMateriaService {
	
	@Autowired
	private IMateriaRepository materiaRepository;

	@Override
	public Materia buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.materiaRepository.seleccionar(id);
	}

	@Override
	public void eliminar(Integer id) {
		this.materiaRepository.borrar(id);
		
	}

	@Override
	public void actualizar(Materia materia) {
		this.materiaRepository.actualizar(materia);
		
	}

	@Override
	public void guardar(Materia materia) {
		this.materiaRepository.insertar(materia);
		
	}
    private MateriaTO convertir(Materia materia) {
        MateriaTO materiaTO = new MateriaTO();
        materiaTO.setId(materia.getId());
        materiaTO.setNombre(materia.getNombre());
        materiaTO.setCreditos(materia.getNumeroCreditos());
        return materiaTO;
    }

	@Override
	public List<MateriaTO> buscarPorCedulaEstudiante(String cedulaEstudiante) {
		List<Materia> lista = this.materiaRepository.buscarPorCedulaEstudiante(cedulaEstudiante);
        List<MateriaTO> listaFinal = new ArrayList<>();
        for (Materia materia : lista) {
            listaFinal.add(this.convertir(materia));
        }

        return listaFinal;
    }
	
	

}

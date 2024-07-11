package com.edu.ec.pw.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.edu.ec.pw.api.repository.modelo.Materia;
import com.edu.ec.pw.api.service.IMateriaService;


@RestController
@RequestMapping(path = "/materias")
public class MateriaController {

    @Autowired
    private IMateriaService materiaService;

    // URL: http://localhost:8080/API/v1.0/Matricula/materias
    @PostMapping
    public void guardar(@RequestBody Materia materia) {
        this.materiaService.guardar(materia);
    }

    // URL: http://localhost:8080/API/v1.0/Matricula/materias/3
    @PutMapping(path = "/{id}")
    public void actualizar(@RequestBody Materia materia, @PathVariable Integer id) {
        materia.setId(id);
        this.materiaService.actualizar(materia);
    }

    // URL: http://localhost:8080/API/v1.0/Matricula/materias/2
    @PatchMapping(path = "/{id}")
    public void actualizarParcial(@RequestBody Materia materia, @PathVariable Integer id) {
        materia.setId(id);
        Materia materiaExistente = this.materiaService.buscar(materia.getId());
        if (materia.getNombre() != null) {
            materiaExistente.setNombre(materia.getNombre());
        }
        if (materia.getNumeroHoras() != null) {
            materiaExistente.setNumeroHoras(materia.getNumeroHoras());
        }
        this.materiaService.actualizar(materiaExistente);
    }

    // URL: http://localhost:8080/API/v1.0/Matricula/materias/3
    @DeleteMapping(path = "/{id}")
    public void borrar(@PathVariable Integer id) {
        this.materiaService.eliminar(id);
    }

    // URL: http://localhost:8080/API/v1.0/Matricula/materias/6
    @GetMapping(path = "/{id}")
    public Materia buscarPorId(@PathVariable Integer id) {
        return this.materiaService.buscar(id);
    }



}

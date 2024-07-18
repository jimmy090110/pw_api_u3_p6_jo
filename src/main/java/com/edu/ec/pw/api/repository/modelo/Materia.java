package com.edu.ec.pw.api.repository.modelo;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "materia")
@JsonIgnoreProperties("estudiante")
public class Materia {
	
	@Id
	@GeneratedValue(generator = "seq_materia", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_materia", sequenceName = "seq_materia",allocationSize  = 1)
	@Column(name = "mtra_id")
	private Integer id;
	
	@Column(name = "mtra_nombre")
	private String nombre;
	
	@Column(name = "mtra_numero_horas")
	private Integer numeroHoras;
	
	@Column(name = "mtra_modalidad")
	private String modalidad;

	
	//Set and Get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNumeroHoras() {
		return numeroHoras;
	}

	public void setNumeroHoras(Integer numeroHoras) {
		this.numeroHoras = numeroHoras;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	@ManyToOne
	@JoinColumn(name="materua_id_estudiante")
	private Estudiante estudiante;
	
	
	@Override
	public String toString() {
		return "Materia [id=" + id + ", nombre=" + nombre + ", numeroHoras=" + numeroHoras + ", modalidad=" + modalidad
				+ "]";
	}
	
	
	
	

}

package com.edu.ec.pw.api.service.to;

import java.io.Serializable;

public class MateriaTO implements Serializable{

	
	private static final long serialVersionUID = 1683355650124783603L;
	
	 private Integer id;
	    private String nombre;
	    private Integer creditos;

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
	    public Integer getCreditos() {
	        return creditos;
	    }
	    public void setCreditos(Integer creditos) {
	        this.creditos = creditos;
	    }

}

package com.jgmanz.jogal.teacherdasboard.models;

public class Materia {
	
	private String nombre;
	private String clave; 
	private String carrera;
	
	public Materia()
	{
		
	}
	
	public Materia(String nombre, String clave, String carrera) {
		super();
		this.nombre = nombre;
		this.clave = clave;
		this.carrera = carrera;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	} 
	

}

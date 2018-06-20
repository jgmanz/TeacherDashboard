package com.jgmanz.jogal.teacherdasboard.models;

public class Alumno extends Persona{
	private String matricula; 
	private Grupo grupo;
	private String fechaIngreso; 
	private String grado;  
	private int edad; 
	
	public Alumno() { 
		
	}
	
	public Alumno(String nombre, String apellidos, String telefono, String claveidentificacion, String email,
			String matricula, Grupo grupo, String fechaIngreso, String grado) {
		super(nombre, apellidos, telefono, claveidentificacion, email);   
		this.matricula = matricula;
		this.grupo = grupo;
		this.fechaIngreso = fechaIngreso;
		this.grado = grado;
		
	} 
	public String getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public String getGrado() {
		return grado;
	}
	public void setGrado(String grado) {
		this.grado = grado;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	} 
	
	public boolean esMayorEdad()
	{
		return edad >= 18?true:false;
	}
}

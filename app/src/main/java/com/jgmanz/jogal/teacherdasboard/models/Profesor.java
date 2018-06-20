package com.jgmanz.jogal.teacherdasboard.models;

public class Profesor extends Persona {
	private String numcontrato;
	private TipoProfesor tipoProfesor;
	private String claveacceso;
	public Profesor() {
		
	} 
	
	public Profesor(String nombre, String apellidos, String telefono, String claveidentificacion, String email,
			String numcontrato, TipoProfesor tipoProfesor, String claveacceso) {
		super(nombre, apellidos, telefono, claveidentificacion, email);
		this.claveacceso = claveacceso;
		this.numcontrato = numcontrato;
		this.tipoProfesor = tipoProfesor;
	}

	public String getClaveacceso() {
		return claveacceso;
	}

	public void setClaveacceso(String claveacceso) {
		this.claveacceso = claveacceso;
	}

	public String getNumcontrato() {
		return numcontrato;
	}
	
	public void setNumcontrato(String numcontrato) {
		this.numcontrato = numcontrato;
	}


	public TipoProfesor getTipoProfesor() {
		return tipoProfesor;
	}


	public void setTipoProfesor(TipoProfesor tipoProfesor) {
		this.tipoProfesor = tipoProfesor;
	} 
	
	
	

}

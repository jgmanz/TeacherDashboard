package com.jgmanz.jogal.teacherdasboard.models;

public class Grupo {
	private String nombregrupo; 
	private String clavegrupo; 
	private Edificio edificio; 
	private Horario[] horarios;
	
	
	public Grupo() { 
		
	}
	
	public Grupo(String nombregrupo, String clavegrupo, Edificio edificio, Horario[] horarios) {
		super();
		this.nombregrupo = nombregrupo;
		this.clavegrupo = clavegrupo;
		this.edificio = edificio;
		this.horarios = horarios;
	}
	public String getNombregrupo() {
		return nombregrupo;
	}
	public void setNombregrupo(String nombregrupo) {
		this.nombregrupo = nombregrupo;
	}
	public String getClavegrupo() {
		return clavegrupo;
	}
	public void setClavegrupo(String clavegrupo) {
		this.clavegrupo = clavegrupo;
	}
	public Edificio getEdificio() {
		return edificio;
	}
	public void setEdificio(Edificio edificio) {
		this.edificio = edificio;
	}
	public Horario[] getHorarios() {
		return horarios;
	}
	public void setHorarios(Horario[] horarios) {
		this.horarios = horarios;
	}

	@Override
	public String toString() { 
		return this.clavegrupo + " - " + this.nombregrupo; 
	}
	
	
	

}

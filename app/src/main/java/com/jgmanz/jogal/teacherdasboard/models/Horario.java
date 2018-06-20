package com.jgmanz.jogal.teacherdasboard.models;

public class Horario {

	private Profesor profesor;
	private String horainicial;
	private String horafinal;
	private String materia;
	private String diaSemana;
	private Dia dia; 
	
	public Horario()
	{
		
	}
	
	public Horario(Profesor profesor, String horainicial, String horafinal, String materia, String diaSemana) {
		this.profesor = profesor;
		this.horainicial = horainicial;
		this.horafinal = horafinal;
		this.materia = materia;
		this.diaSemana = diaSemana;
	}
	
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	public String getHorainicial() {
		return horainicial;
	}
	public void setHorainicial(String horainicial) {
		this.horainicial = horainicial;
	}
	public String getHorafinal() {
		return horafinal;
	}
	public void setHorafinal(String horafinal) {
		this.horafinal = horafinal;
	}
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public String getDiaSemana() {
		return diaSemana;
	}
	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}
	
	 
	public Dia getDia() {
		return dia;
	}
	public void setDia(Dia dia) {
		this.dia = dia;
	}
	/*
	@Override
	public String toString() { 
		return "Dia: " + this.diaSemana + "\tHora: " + this.horafinal + "-" + this.horafinal+ "\tProfesor: " + this.profesor.getNombre() + "\tMateria:" + this.materia;
	}*/
	
	
	
	
}

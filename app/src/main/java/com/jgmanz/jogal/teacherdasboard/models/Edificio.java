package com.jgmanz.jogal.teacherdasboard.models;

public class Edificio {
	private String nombre; 
	private char letra;
	private float lat;
	private float log;
	
	public Edificio(String nombre, char letra, float lat, float log) {
		this.nombre = nombre;
		this.letra = letra;
		this.lat = lat;
		this.log = log;
	}
	
	public Edificio()
	{
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public char getLetra() {
		return letra;
	}
	public void setLetra(char letra) {
		this.letra = letra;
	}
	public float getLat() {
		return lat;
	}
	public void setLat(float lat) {
		this.lat = lat;
	}
	public float getLog() {
		return log;
	}
	public void setLog(float log) {
		this.log = log;
	}


	@Override
	public String toString() {
		return nombre;
	}
}

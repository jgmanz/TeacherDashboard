package com.jgmanz.jogal.teacherdasboard.models;

public class Persona {
	private String nombre; 
	private String apellidos; 
	private String telefono;
	private String claveidentificacion; 
	private String email; 
	
	public Persona()
	{
		
	}
	
	public Persona(String nombre, String apellidos, String telefono, String claveidentificacion, String email)
	{
		this.nombre = nombre; 
		this.apellidos = apellidos; 
		this.telefono = telefono; 
		this.claveidentificacion = claveidentificacion; 
		this.email = email; 
	}
	
	public String getNombre() {
		return nombre; 
	}
	
	public String getApellidos()
	{
		return apellidos; 
		
	}
	public String getTelefono()
	{
		return telefono; 
	}
	public String getEmail()
	{
		return email; 
	}
	public void setNombre(String nombre)
	{
		this.nombre = nombre; 
	}
	public void setApelldos(String apellidos)
	{
		this.apellidos = apellidos; 
	}
	
	public void setTelefono(String telefono)
	{
		this.telefono = telefono; 
	}
	public void setEmail(String email)
	{
		this.email = email; 
	}

}

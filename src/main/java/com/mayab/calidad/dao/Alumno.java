package com.mayab.calidad.dao;

public class Alumno {
	
	private String nombre;
	private int id;
	private int edad;
	private String email;
	private float promedio;
	
	public Alumno() {
		this.nombre = "";
		this.id = 0;
		this.edad = 0;
		this.email = "";
		this.promedio = 0;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getId() {
		return id;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String nuevoEmail) {
		this.email = nuevoEmail;
	}
	
	public float getPromedio() {
		return promedio;
	}
	
	public void setPromedio(float nuevoPromedio) {
		this.promedio = nuevoPromedio;
	}
	
	@Override
    public String toString() { 
        return "Nombre alumno: " + getNombre()
        	+ "\nId alumno: " + getId()
        	+ "\nEdad alumno: " + getEdad()
        	+ "\nEmail alumno: " + getEmail()
        	+ "\nPromedio alumno: " + getPromedio(); 
    } 
	
}

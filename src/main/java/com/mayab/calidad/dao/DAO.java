package com.mayab.calidad.dao;

public interface DAO {
	
	public void addAlumno(Alumno a);
	public void deleteAlumno(Alumno a);
	public void updatePromedioAlumno(Alumno a, float nuevoPromedio);
	public Alumno getAlumno(int id);
	
}

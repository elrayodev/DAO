package com.mayab.calidad.dao;

public interface DAO {
	
	public boolean addAlumno(Alumno a);
	public void delateAlumno(Alumno a);
	public void updatePromedioAlumno(Alumno a, float nuevoPromedio);
	public Alumno getAlumno(int id);
	
}

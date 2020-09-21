package com.mayab.calidad.dao;

public interface DAO {
	
	void addAlumno(Alumno a);
	void delateAlumno(Alumno a);
	void updatePromedioAlumno(Alumno a, float nuevoPromedio);
	Alumno getAlumno(int id);
	
}

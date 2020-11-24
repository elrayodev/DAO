package com.mayab.calidad.dao;

import java.sql.Connection;

public interface DAO {
	
	public Connection getConnection();
	public void addAlumno(Alumno a);
	public void deleteAlumno(Alumno a);
	public void updatePromedioAlumno(Alumno a, float nuevoPromedio);
	public Alumno getAlumno(int id);
	
	
}

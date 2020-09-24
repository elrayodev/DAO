package com.mayab.calidad.dao;

public interface DAOM {
	public int addAlumno(Alumno a);
	public int deleteAlumno(Alumno a);
	public float updatePromedioAlumno(Alumno a, float nuevoPromedio);
	public Alumno getAlumno(int id);
	
}

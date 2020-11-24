package com.mayab.calidad.dao;

public class AlumnoDriver {
	
	public static void main(String[] args) {
		
		AlumnoDAOOracle dao = new AlumnoDAOOracle();
		Alumno a = new Alumno("Eloy", 4, 24, "eloy.jdl@gmail.com", 9.6f);
		Alumno a2 = new Alumno("Jimena", 3, 22, "jimena@anahuac.mx", 8.7f);
		
		dao.getConnection();
		//dao.addAlumno(a);
		dao.updatePromedioAlumno(a2, 5.6f);
		dao.updatePromedioAlumno(a, 9.9f);
		//dao.updatePromedioAlumno(a, 6.8f);
		//dao.addAlumno(a2);
		//dao.addAlumno(a);
		//dao.addAlumno(a2);
		//dao.updatePromedioAlumno(a, 9.9f);
		//dao.deleteAlumno(a2);
	
	}

}

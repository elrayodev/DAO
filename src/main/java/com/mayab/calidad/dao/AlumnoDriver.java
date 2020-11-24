package com.mayab.calidad.dao;

public class AlumnoDriver {
	
	public static void main(String[] args) {
		
		AlumnoDAOOracle dao = new AlumnoDAOOracle();
		Alumno a = new Alumno("Eloy", 4, 24, "eloy.jdl@gmail.com", 9.6f);
		Alumno a2 = new Alumno("Jimena", 3, 22, "jimena@anahuac.mx", 8.7f);
		
		dao.getConnection();
		
		//dao.addAlumno(a);
		//dao.addAlumno(a2);
		System.out.println("Promedio a:" + a.getPromedio());
		System.out.println("Promedio a2:" + a2.getPromedio());

		dao.updatePromedioAlumno(a, 7.2f);
		dao.updatePromedioAlumno(a2, 5.3f);
		
		System.out.println("Promedio a:" + a.getPromedio());
		System.out.println("Promedio a2:" + a2.getPromedio());


	}

}

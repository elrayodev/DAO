package com.mayab.calidad.dao;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

public class TestDAO {
	
	Alumno al = new Alumno();
	DAOFake dao;
	int result;
	int expectedResult;
	
	@Before
	public void setUp() {
		dao = new DAOFake();
	}

	@Test
	public void addAlumnoFakeTest() {
		
		System.out.println("\n-----addAlumnoFakeTest-----");
		System.out.println("Cantidad de alumnos en sistema: " + dao.credenciales.size());
		
		//Agregamos alumno
		dao.addAlumno(al);
		//endExercise
		
		System.out.println("Cantidad de alumnos en sistema: " + dao.credenciales.size());
		
		expectedResult = 1;
		result = dao.credenciales.size();
		
		assertThat(result, is(expectedResult));
		//endVerify
	}
	
	@Test
	public void delateAlumnoFakeTest() {
		
		System.out.println("-----delateAlumnoFakeTest-----");
		System.out.println("Cantidad de alumnos en sistema: " + dao.credenciales.size());
		
		//Agregamos alumno
		dao.addAlumno(al);
		
		System.out.println("Cantidad de alumnos en sistema: " + dao.credenciales.size());
		
		//Eliminamos alumno
		dao.delateAlumno(al);
		
		System.out.println("Cantidad de alumnos en sistema: " + dao.credenciales.size());
		
		expectedResult = 0;
		result = dao.credenciales.size();
		
		assertThat(result, is(expectedResult));
		//endVerify
	}
	
	@Test
	public void updateAlumnoFakeTest() {
		
		float nuevoPromedio = 5.2f;
		
		System.out.println("\n-----updateAlumnoFakeTest-----");
		
		//Agregamos alumno
		dao.addAlumno(al);
		System.out.println("Promedio: " + al.getPromedio());
		
		//Modificamos promedio
		dao.updatePromedioAlumno(al, nuevoPromedio);
		System.out.println("Nuevo Promedio: " + al.getPromedio());
		
		float expectedResult = 5.2f;
		float result = al.getPromedio();
		
		assertThat(result,is(expectedResult));
	}
	
	@Test
	public void getAlumnoFakeTest() {
		
		System.out.println("\n-----getAlumnoFakeTest-----");
		System.out.println("\tAntes de ejercitar");
		System.out.println(dao.getAlumno(al.getId()));
				
		//Agregamos alumno
		dao.addAlumno(al);
		
		//ExpectedResult
		System.out.println("\tDespués de ejercitar");
		System.out.println(dao.getAlumno(al.getId()));
		
		Alumno result = dao.getAlumno(al.getId());
		Alumno expectedResult = al;
		
		assertThat(result,is(expectedResult));
		//endVerify
		
	}
	
	

}

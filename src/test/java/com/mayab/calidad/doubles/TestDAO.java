package com.mayab.calidad.doubles;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

import com.mayab.calidad.dao.Alumno;
import com.mayab.calidad.dao.DAOFake;

public class TestDAO {
	
	Alumno al = new Alumno();
	Alumno al2 = new Alumno(1);
	DAOFake dao;
	int result;
	int expectedResult;
	
	@Before
	public void setUp() {
		dao = new DAOFake();
		dao.addAlumno(al);
	}

	@Test
	public void addAlumnoFakeTest() {
		
		System.out.println("-----addAlumnoFakeTest-----");
		System.out.println("Cantidad de alumnos antes de ejercitar: " + dao.credenciales.size());
		
		expectedResult = dao.credenciales.size();
		
		//Agregamos alumno
		dao.addAlumno(al2);
		//endExercise
		
		System.out.println("Cantidad de alumnos despues de ejercitar: " + dao.credenciales.size());
		
		
		result = dao.credenciales.size();
		
		assertThat(result, is(expectedResult+1));
		//endVerify
	}
	
	@Test
	public void deleteAlumnoFakeTest() {
		
		System.out.println("-----delateAlumnoFakeTest-----");
		System.out.println("Cantidad de alumnos antes de ejercitar: " + dao.credenciales.size());
		
		expectedResult = dao.credenciales.size()-1;
		
		//Eliminamos alumno
		dao.deleteAlumno(al);
		
		System.out.println("Cantidad de alumnos despues de ejercitar: " + dao.credenciales.size());
		
		result = dao.credenciales.size();
		
		assertThat(result, is(expectedResult));
		//endVerify
	}
	
	@Test
	public void updateAlumnoFakeTest() {
		
		float nuevoPromedio = 5.5f;
		
		System.out.println("-----updateAlumnoFakeTest-----");
		System.out.println("Promedio alumno antes de ejercitar: " + al.getPromedio());
		
		//Ejercitamos codigo
		dao.updatePromedioAlumno(al, nuevoPromedio);
		System.out.println("Promedio alumno despues de ejercitar: " + al.getPromedio());
		
		float expectedResult = 5.5f;
		float result = al.getPromedio();
		
		assertThat(result,is(expectedResult));
	}
	
	@Test
	public void getAlumnoFakeTest() {

		System.out.println("\n-----getAlumnoFakeTest-----");
		System.out.println("\tAntes de ejercitar");
		System.out.println(dao.getAlumno(al2.getId()));
		
		dao.addAlumno(al2);
		
		//ExpectedResult
		System.out.println("\tDespués de ejercitar");
		System.out.println(dao.getAlumno(al2.getId()));
		
		Alumno result = dao.getAlumno(al2.getId());
		Alumno expectedResult = al2;
		
		assertThat(result,is(expectedResult));
		//endVerify
		
	}
	
	

}

package com.mayab.calidad.dao;

import static org.junit.Assert.*;

//import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashMap;

public class TestDAOmockito {
	
	private HashMap<Integer,Alumno> credenciales = new HashMap<Integer,Alumno>();
	private Alumno a = new Alumno();
	private DAOM daoMock;
	
	@Before
	public void setUp() {
		
		//Creamos mock
		daoMock =  mock(DAOM.class);
		
		//Hardcodeamos mockito de addAlumno
		//Answer debe devolver lo mismo que nuestro método
		when(daoMock.addAlumno((Alumno) anyObject())).thenAnswer(new Answer<Integer>(){
			public Integer answer(InvocationOnMock invocation) throws Throwable {
				a = (Alumno) invocation.getArguments()[0];
				//Agregamos alumno a hash
				credenciales.put(a.getId(), a);
				return credenciales.size();	
			}		
		});
		
	}
	

	@Test
	public void testAddAlumno() {
		
		System.out.println("---Test addAlumno mockito---");
		System.out.println("Cantidad de alumnos antes de ejercitar: " + credenciales.size());
		int expectedResult = credenciales.size()+1;
		
		//Ejercitamos mock
		daoMock.addAlumno(a);
		System.out.println("Cantidad de alumnos despues de ejercitar: " + credenciales.size());
		int result = credenciales.size();
		
		//Verify
		assertThat(result,is(expectedResult));
		
	}
	
	@Test
	public void testDeleteAlumno() {

		daoMock.addAlumno(a);
		
		//Hardcodeamos comportamiento de deleteAlumno
		when(daoMock.deleteAlumno(a)).thenAnswer(new Answer<Integer>(){
			public Integer answer(InvocationOnMock invocation) throws Throwable{
				a = (Alumno) invocation.getArguments()[0];
				credenciales.remove(a.getId());
				return credenciales.size();
			}
			
		});
		
		System.out.println("---Test deleteAlumno mockito---");
		System.out.println("Cantidad de alumnos antes de ejercitar: " + credenciales.size());
		int expectedResult = credenciales.size()-1;
		
		//Ejercitamos mock
		daoMock.deleteAlumno(a);
		System.out.println("Cantidad de alumnos despues de ejercitar: " + credenciales.size());
		int result = credenciales.size();
		
		//Verify
		assertThat(result,is(expectedResult));
		
	}

	@Test
	public void testUpdatePromedioAlumno() {
		
		daoMock.addAlumno(a);
		
		//Hardcodeamos comportamiento de uptadePromedioAlumno
		when(daoMock.updatePromedioAlumno((Alumno) anyObject(), anyFloat())).thenAnswer(new Answer<Float>(){
			public Float answer(InvocationOnMock invocation) throws Throwable{
				a = (Alumno) invocation.getArguments()[0];
				float nuevoPromedio = (Float) invocation.getArguments()[1];
				credenciales.get(a.getId()).setPromedio(nuevoPromedio);
				return credenciales.get(a.getId()).getPromedio();
			}
		});
		
		System.out.println("---Test updatePromedioAlumno mockito---");
		System.out.println("Promedio alumno antes de ejercitar: " + a.getPromedio());
		float expectedResult = 9.13f;
		
		//Ejercitamos mock
		daoMock.updatePromedioAlumno(a, 9.13f);
		System.out.println("Promedio alumno despues de ejercitar: " + a.getPromedio());
		float result = a.getPromedio();
		
		assertThat(result,is(expectedResult));
		
	}
	
	@Test
	public void testGetAlumno() {
		
		Alumno al = new Alumno(2);
		daoMock.addAlumno(al);
		
		//Hardcodeamos comportamiento de getId
		when(daoMock.getAlumno(anyInt())).thenAnswer(new Answer<Alumno>(){
			public Alumno answer(InvocationOnMock invocation) throws Throwable{
				int id = (Integer) invocation.getArguments()[0];
				a = credenciales.get(id);
				return a;
			}
		});
		
		System.out.println("---Test getAlumno---");
		System.out.println("Id alumno esperado: " + al.getId());
		Alumno expectedResult = al;
		Alumno result = daoMock.getAlumno(al.getId());
		System.out.println("Id alumno despues de ejercitar: " + daoMock.getAlumno(al.getId()).getId());
		assertThat(result,is(expectedResult));
	}
}

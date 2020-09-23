package com.mayab.calidad.dao;

import static org.junit.Assert.*;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestDAOmockito {
	
	private Alumno a;
	private DAO daoMock;
	
	
	@Before
	public void setUp() {
		daoMock = mock(DAO.class);
		a = new Alumno();
		
		daoMock.addAlumno(a);
		
	}
	

	@Test
	public void testAddAlumno() {

		when(daoMock.addAlumno((Alumno) anyObject())).thenAnswer(new Answer<Boolean>(){

			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				
				Alumno a = (Alumno) invocation.getArguments()[0];
				
				return true;
				
			}
		
		});
		
		boolean result = daoMock.addAlumno(a);
		boolean expectedResult = true;
		
		assertTrue(result == expectedResult);
	}


	
}

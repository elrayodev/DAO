package com.mayab.calidad.dao;

import static org.junit.Assert.*;

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
		
	}
	

	@Test
	public void testAddAlumno() {

		when(daoMock.addAlumno((Alumno) anyObject())).thenAnswer(new Answer<DAO>() {

			public  DAO answer(InvocationOnMock invocation) throws Throwable {
				
				daoMock.addAlumno(a);
				
				return daoMock;
				;
			}
			
			
		});
		
	}



	
}

package com.mayab.calidad.dbunit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mayab.calidad.dao.Alumno;
import com.mayab.calidad.dao.AlumnoDAOOracle;

import org.dbunit.Assertion;
import org.dbunit.DBTestCase;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

import java.io.File;
import java.io.InputStream;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.IDatabaseConnection;

public class TestAlumnoOracleDAOOracle extends DBTestCase{

	Alumno a = new Alumno("Jorge", 2, 18, "jorge@gmail.com", 7.8f);
	AlumnoDAOOracle dao = new AlumnoDAOOracle();
	
	//Creamos conexion a dbunit
	public TestAlumnoOracleDAOOracle(String name) {
		super(name);
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "oracle.jdbc.driver.OracleDriver");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:oracle:thin:@localhost:1521/xe");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "dbunit");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "dbunit");
	}


	@Before
	public void setUp() throws Exception{
		
		super.setUp();
		IDatabaseConnection con = getConnection();
		try {
			DatabaseOperation.CLEAN_INSERT.execute(con, getDataSet());
		}
		finally {
			con.close();
		}
	}
	
	@After
	public void tearDown() throws Exception{
		
	}

	@Test
	public void testInsert() {

		//Ejercicio de codigo
		dao.addAlumno(a);
		
		//Verify
		try {
			IDataSet databaseDataSet = getConnection().createDataSet();
			ITable actualTable = databaseDataSet.getTable("alumnos");
			
			//Leemos datos del archivo esperado
			//InputStream xmlFile = getClass().getResourceAsStream("/insert_result.xml");
			//IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(xmlFile);
			
			IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("src/resources/insert_result.xml"));
			ITable expectedTable = expectedDataSet.getTable("alumnos");
			
			Assertion.assertEquals(expectedTable, actualTable);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testDelete() {
		
		//Ejercicio de codigo
		dao.addAlumno(a);
		dao.deleteAlumno(a);
		
		
		//Verify
				try {
					IDataSet databaseDataSet = getConnection().createDataSet();
					ITable actualTable = databaseDataSet.getTable("alumnos");
					
					//Leemos datos del archivo esperado
					//InputStream xmlFile = getClass().getResourceAsStream("/insert_result.xml");
					//IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(xmlFile);
					
					IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("src/resources/alumno_init.xml"));
					ITable expectedTable = expectedDataSet.getTable("alumnos");
					
					Assertion.assertEquals(expectedTable, actualTable);
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
				
	}
	
	@Test
	public void testUpdatePromedio() {
		
		Alumno a2 = new Alumno("Jimena", 3, 22, "jimena@gmail.com", 8.7f);
		dao.addAlumno(a2);
		System.out.println("Promedio al inicio: " + a2.getPromedio());
		dao.updatePromedioAlumno(a2, 7.4f);
		System.out.println("Promedio modificado: " + a2.getPromedio());
		
		
		//Verify
				try {
					IDataSet databaseDataSet = getConnection().createDataSet();
					ITable actualTable = databaseDataSet.getTable("alumnos");
					Object actualPromedio = actualTable.getValue(0, "promedio");
					
					//Leemos datos del archivo esperado
					//InputStream xmlFile = getClass().getResourceAsStream("/insert_result.xml");
					//IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(xmlFile);
					
					IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("src/resources/alumno_update.xml"));
					ITable expectedTable = expectedDataSet.getTable("alumnos");
					Object expectedPromedio = expectedTable.getValue(0, "promedio");
					
					//Assertion.assertEquals(expectedTable, actualTable);
					assertEquals(expectedPromedio, actualPromedio);
					
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
				
	}
	
	
	@Override
	protected IDataSet getDataSet() throws Exception {
		// TODO Auto-generated method stub
		//InputStream xmlFile = getClass().getResourceAsStream("/alumno_init.xml");
		//return new FlatXmlDataSetBuilder().build(xmlFile);
		
		return new FlatXmlDataSetBuilder().build(new File("src/resources/alumno_init.xml"));
	}

}

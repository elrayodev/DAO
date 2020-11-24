package com.mayab.calidad.dao;

import java.sql.Connection;
import java.util.HashMap;

public class DAOFake implements DAO{
	
	public HashMap<Integer,Alumno> credenciales = new HashMap<Integer,Alumno>();
	
	public void addAlumno(Alumno a) {
		
		//Corroboramos que la key exista
		if(credenciales.containsKey(a.getId())){
			System.out.println("El alumno ya se encuentra en el sistema");
		}else {
			//Agrega alumno al hash 
			credenciales.put(a.getId(), a);
		} //endif
		
	} //endAddAlumno method

	public void deleteAlumno(Alumno a) {
		
		//Corroboramos que la key exista
		if(credenciales.containsKey(a.getId())) {
			//Removemos alumno del hash
			credenciales.remove(a.getId());
		}else {
			System.out.println("El alumno no existe en el sistema");
		} //endif
		
	} //endDelateAlumno method


	public void updatePromedioAlumno(Alumno a, float nuevoPromedio) {

		if(credenciales.containsKey(a.getId())) {	
			a.setPromedio(nuevoPromedio);
		}else {
			System.out.println("El alumno no existe en el sistema");
		} //endif
		
	} //endUpdatePromedioAlumno method

	public Alumno getAlumno(int id) {
		
		Alumno al = new Alumno();
		
		if(credenciales.containsKey(id)) {
			 al = credenciales.get(id);
			 return al;
		}else {
			System.out.println("El alumno no existe en el sistema");
			return null;
		}
		
	}

	public Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}

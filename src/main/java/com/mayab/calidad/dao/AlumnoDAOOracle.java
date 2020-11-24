package com.mayab.calidad.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlumnoDAOOracle implements DAO{

	public void addAlumno(Alumno a) {
		
		Connection con = getConnection();
		PreparedStatement ps;
		
		try {
			
			ps = con.prepareStatement(
					"insert into alumnos(id, first_name, edad, email, promedio) values(?,?,?,?,?)");
			ps.setInt(1, a.getId());
			ps.setString(2, a.getNombre());
			ps.setInt(3, a.getEdad());
			ps.setString(4, a.getEmail());
			ps.setFloat(5, a.getPromedio());
			
			int status = ps.executeUpdate();
			
			con.close();
			
		}catch(Exception ex) {
			
			ex.printStackTrace();
			
		}
		
	}

	public void deleteAlumno(Alumno a) {

		Connection con = getConnection();
		PreparedStatement ps;
		
		try {
			
			ps = con.prepareStatement(
					"delete from alumnos where id =?");
			ps.setInt(1, a.getId());
			
			int status = ps.executeUpdate();
			
			con.close();
			
		}catch(Exception ex) {
			
			ex.printStackTrace();
			
		}
		
		
	}

	public void updatePromedioAlumno(Alumno a, float nuevoPromedio) {
		
		Connection con = getConnection();
		PreparedStatement ps;
		
		a.setPromedio(nuevoPromedio);
		
		try {
			
			ps = con.prepareStatement(
					"update alumnos set promedio =? where id =?");
			ps.setFloat(1, nuevoPromedio);
			ps.setInt(2, a.getId());
			
			int status = ps.executeUpdate();
			
			con.close();
			
		}catch(Exception ex) {
			
			ex.printStackTrace();
			
		}
		
		
	}

	public Alumno getAlumno(int id) {
		Connection con = getConnection();
		PreparedStatement ps;
		ResultSet rs;
		Alumno a = null;
		
		try {
			
			ps = con.prepareStatement(
					"select * from alumnos where id =?");
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				a = new Alumno(rs.getString("first_name"),
						rs.getInt("id"), rs.getInt("edad"),
						rs.getString("email"), rs.getFloat("promedio"));
				
			}
			
			int status = ps.executeUpdate();
			
			con.close();
			
		}catch(Exception ex) {
			
			ex.printStackTrace();
			
		}
		
		return a;
		
	}

	public Connection getConnection() {
		// TODO Auto-generated method stub
		
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","dbunit","dbunit");
		}catch(Exception e) {
			
			System.out.println(e);
			
		}
		
		return con;
		
	}

}

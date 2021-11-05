package com.add2.conectores.proc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_procAlmacenadoIn {

	public static void muestraErrorSQL(SQLException e) {
		System.err.println("SQL ERROR mensaje: " + e.getMessage());
		System.err.println("SQL Estado: " + e.getSQLState());
		System.err.println("SQL codigo especifico: " + e.getErrorCode());
	}

public static void main(String[] args) {

		String basedatos = "prueba";
		String host = "localhost";
		String port = "3306";
		String parAdic = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String urlConnection = "jdbc:mysql://" + host + ":" + port + "/" + basedatos + parAdic;
		String user = "root";
		String pwd = "root";

		try (Connection conn = DriverManager.getConnection(urlConnection, user, pwd);
				CallableStatement sentencia = conn.prepareCall("{call obtenerClientes(?)}"))
				 {

		    sentencia.setString(1, "GARCIA");
		    ResultSet rs = sentencia.executeQuery();
		
		    while (rs.next()) {
		        System.out.println("DNI: " + rs.getString("DNI"));
		        System.out.println("Apellidos: " + rs.getString("APELLIDOS"));
		        System.out.println("CP: " + rs.getString("CP"));
		      }
			
			
		} catch (SQLException e) {
			muestraErrorSQL(e);
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}

}

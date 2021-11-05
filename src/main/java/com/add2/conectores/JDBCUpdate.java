package com.add2.conectores;

import java.sql.*;

class JDBCUpdate {
	public static void main(String args[]) {
		try {

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba", "root", "root");

			String sentenciaSql = "UPDATE persona SET nombre = ?, apellido = ? " + "WHERE id = ?";
			PreparedStatement sentencia = null;

			try {
				sentencia = con.prepareStatement(sentenciaSql);
				sentencia.setString(1, "Simon");
				sentencia.setString(2, "Sanchez");
				sentencia.setInt(3, 5);
				sentencia.executeUpdate();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			} finally {
				if (sentencia != null)
					try {
						sentencia.close();
					} catch (SQLException sqle) {
						sqle.printStackTrace();
					}
			}

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
package com.add2.conectores;

import java.sql.*;

class JDBCDelete {
	public static void main(String args[]) {

		String sentenciaSql = "DELETE persona WHERE id = ?";
		PreparedStatement sentencia = null;

		try {

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba", "root", "root");

			sentencia = con.prepareStatement(sentenciaSql);
			sentencia.setInt(1, 5);
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

	}

}
package com.add2.conectores;

import java.sql.*;

class JDBCConSelect {
	public static void main(String args[]) {
		try {

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba", "root", "root");

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from persona");
			while (rs.next())
				System.out
						.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getDate(4));
			con.close();
	} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
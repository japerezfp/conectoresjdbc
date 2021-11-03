package com.add2.conectores;

import java.sql.*;

public class keyLastInsert {

  public static void muestraErrorSQL(SQLException e) {
    System.err.println("SQL ERROR mensaje: " + e.getMessage());
    System.err.println("SQL Estado: " + e.getSQLState());
    System.err.println("SQL codigo: " + e.getErrorCode());
  }

  public static void main(String[] args) {

    String basedatos = "prueba";
    String host = "localhost";
    String port = "3306";
    String parAdic = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String urlConnection = "jdbc:mysql://" + host + ":" + port + "/" + basedatos + parAdic;
    String user = "root";
    String pwd = "root";
    
    
    Statement stmt = null;
	ResultSet rs = null;
    
    		try {
                Connection conn = DriverManager.getConnection(urlConnection, user, pwd);

                    //
                    // Create a Statement instance that we can use for
                    // 'normal' result sets.

                    stmt = conn.createStatement();

                    //
                    // Issue the DDL queries for the table for this example
                    //

                    stmt.executeUpdate("DROP TABLE IF EXISTS autoIncTutorial");
                    stmt.executeUpdate(
                            "CREATE TABLE autoIncTutorial ("
                            + "priKey INT NOT NULL AUTO_INCREMENT, "
                            + "dataField VARCHAR(64), PRIMARY KEY (priKey))");

                    //
                    // Insert one row that will generate an AUTO INCREMENT
                    // key in the 'priKey' field
                    //

                    stmt.executeUpdate(
                            "INSERT INTO autoIncTutorial (dataField) "
                            + "values ('Can I Get the Auto Increment Field?')");

                    //
                    // Use the MySQL LAST_INSERT_ID()
                    // function to do the same thing as getGeneratedKeys()
                    //

                    int autoIncKeyFromFunc = -1;
                    rs = stmt.executeQuery("SELECT LAST_INSERT_ID()");

                    if (rs.next()) {
                        autoIncKeyFromFunc = rs.getInt(1);
                    } else {
                        // throw an exception from here
                    }

                    System.out.println("Key returned from " +
                                       "'SELECT LAST_INSERT_ID()': " +
                                       autoIncKeyFromFunc);

                } catch (SQLException e) {
					e.printStackTrace();
				} finally {

                    if (rs != null) {
                        try {
                            rs.close();
                        } catch (SQLException ex) {
                            // ignore
                        }
                    }

                    if (stmt != null) {
                        try {
                            stmt.close();
                        } catch (SQLException ex) {
                            // ignore
                        }
                    }
                }
      

  }}

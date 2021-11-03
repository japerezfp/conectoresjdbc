package com.add2.conectores;

import java.sql.*;

public class KeyGeneratedPreparedStament {

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
    		    // 'normal' result sets assuming you have a
    		    // Connection 'conn' to a MySQL database already
    		    // available

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

    		    
    		    	PreparedStatement sInsert = conn.prepareStatement("INSERT INTO autoIncTutorial (dataField) VALUES (?)",
    		    			PreparedStatement.RETURN_GENERATED_KEYS); 

    		        sInsert.setString(1, "Can I Get the Auto Increment Field");
    		        sInsert.executeUpdate();

    		        
    
    		    //
    		    // Example of using Statement.getGeneratedKeys()
    		    // to retrieve the value of an auto-increment
    		    // value
    		    //

    		    int autoIncKeyFromApi = -1;

    		    rs = sInsert.getGeneratedKeys();

    		    if (rs.next()) {
    		        autoIncKeyFromApi = rs.getInt(1);
    		    } else {

    		        // throw an exception from here
    		    }

    		    System.out.println("Key returned from getGeneratedKeys():"
    		        + autoIncKeyFromApi);
    		    
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

}
}
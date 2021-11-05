package com.aad.conector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class JDBC_insert {

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

    try (
            Connection c = DriverManager.getConnection(urlConnection, user, pwd);
            Statement s = c.createStatement()) {

      int nFil = s.executeUpdate("INSERT INTO CLIENTES (DNI,APELLIDOS,CP) VALUES "
              + "('78901234X','GARCIA','44126'),"
              + "('89012345E','RODRIGUEZ', null),"
              + "('56789012B','ANDUJAR','29730'),"
              + "('09876543K','PEREZ', null);");

      System.out.println(nFil + " Filas insertadas.");

    } catch (SQLException e) {
      muestraErrorSQL(e);
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
  }

}

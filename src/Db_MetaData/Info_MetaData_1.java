package Db_MetaData;

import java.sql.*;

public class Info_MetaData_1 {
  public static void main(String[] args) {
    showInfo_MetaData_Table();
  }

  static void showInfo_MetaData() {
    String url = "jdbc:mysql://localhost:3306/storaged_procedures";
    String user = "root";
    String password = "";
    Connection connection = null;

    try {
      connection = DriverManager.getConnection(url, user, password);

      // Obtaining the database metadata
      DatabaseMetaData metaData = connection.getMetaData();
      System.out.println("Product name: " + metaData.getDatabaseProductName());
      System.out.println("Product version: " + metaData.getDatabaseProductVersion());
      System.out.println("Driver name: " + metaData.getDriverName());
      System.out.println("Driver version: " + metaData.getDriverVersion());
    } catch(SQLException e) {
      throw new RuntimeException(e);
    } finally {
      assert connection != null;
      try {
        connection.close();
      } catch(SQLException e) {
        throw new RuntimeException(e);
      }
    }
  }

  static void showInfo_MetaData_Table() {
    String url = "jdbc:mysql://localhost:3306/storaged_procedures";
    String user = "root";
    String password = "";
    Connection connection = null;
    ResultSet resultSet = null;

    try {
      connection = DriverManager.getConnection(url, user, password);

      // Obtaining the database metadata
      DatabaseMetaData metaData = connection.getMetaData();

      // Getting the list of tables
      String[] types = {"TABLE"};
      resultSet = metaData.getTables(null, null, "p%", types);
      while(resultSet.next()) {
        String tableName = resultSet.getString("TABLE_NAME");
        System.out.println(tableName);
      }
      System.out.println("===========================================");

      resultSet = metaData.getColumns(null, null, "products_table", null);

      while(resultSet.next()) {
        String columnName = resultSet.getString("COLUMN_NAME");
        System.out.println(columnName);
      }

    } catch(SQLException e) {
      throw new RuntimeException(e);
    } finally {
      assert connection != null;
      assert resultSet != null;
      try {
        resultSet.close();
        connection.close();
      } catch(SQLException e) {
        throw new RuntimeException(e);
      }
    }
  }
}

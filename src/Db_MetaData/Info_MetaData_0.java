package Db_MetaData;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Info_MetaData_0 {
  public static void main(String[] args) {
    showInfo_MetaData();
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
}

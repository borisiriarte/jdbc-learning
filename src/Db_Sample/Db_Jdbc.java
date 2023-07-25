package Db_Sample;

import java.sql.*;

public class Db_Jdbc {
  public static void main(String[] args) {
    Connection sampleConnection = null;
    try {
      sampleConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_course", "root", "");
      // 2- Create a statement Object
      Statement sampleStatement = sampleConnection.createStatement();
      // 3- Execute a SQL Query
      String sqlQuery = "SELECT * FROM products_table";
      ResultSet resultSet = sampleStatement.executeQuery(sqlQuery);

      // 4- Iterate result Set
      while (resultSet.next()) {
        System.out.println(resultSet.getString("id_article"));
        System.out.println(resultSet.getString("name"));
      }

      // 5- Close connection
      sampleConnection.close();
      sampleStatement.close();
      resultSet.close();
    } catch(SQLException e) {
      System.out.println("Something is wrong, and it due to your code: " + e.getMessage());
    }
  }
}

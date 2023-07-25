package Db_Sample;

import java.sql.*;
import java.sql.ResultSet;

import static java.sql.DriverManager.getConnection;

public class DesignInAdvance {
  public static void main(String[] args) {
    try {
      // 1- Create Connection
      Connection sqlConnection = getConnection("jdbc:mysql://localhost:3306/jdbc_course", "root", "");
      // 2- Prepare Query
      String mySqlQuery = "SELECT * FROM products_table WHERE section_art=? AND price>?";
      PreparedStatement preparedStatement = sqlConnection.prepareStatement(mySqlQuery);

      // 3- Set query parameters
      preparedStatement.setString(1, "Jugueteria");
      preparedStatement.setDouble(2, 10);

      // 4- Execute query and traverse query parameters
      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        System.out.println(resultSet.getString("id_article") + " - " + resultSet.getString("name") + " - " + resultSet.getDouble("price"));
      }

      // 5- Close connection
      sqlConnection.close();
      preparedStatement.close();
      resultSet.close();

    } catch(SQLException e) {
      throw new RuntimeException(e);
    }
    // 2- Create Statement
  }
}

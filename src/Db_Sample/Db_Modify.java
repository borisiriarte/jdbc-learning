package Db_Sample;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Db_Modify {
  public static void main(String[] args) {
    try {
      // 1- Create a connection
      Connection sampleConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_course", "root", "");
      // 2- Create a statement Object
      Statement sampleStatement = sampleConnection.createStatement();

      // 3- Create records
      /*String sqlInstruction = "INSERT INTO products_table (section_art, name, price, date_in, imported, home_country) VALUES ('Electrodomesticos','Samsung Galaxy S10', 899.99, '2020-01-01', 'VERADERO', 'China')";*/
      /*String sqlInstruction = "UPDATE products_table SET price = price * 2 WHERE id_article=16";*/
      String sqlInstruction = "DELETE FROM products_table WHERE id_article=16";
      sampleStatement.executeUpdate(sqlInstruction);

      System.out.println("Data modified successfully");
      // 4- Close the connection
      sampleConnection.close();
    } catch(SQLException e) {
      throw new RuntimeException(e);
    }
  }
}

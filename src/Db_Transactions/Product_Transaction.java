package Db_Transactions;

import javax.swing.*;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Product_Transaction {
  public static void main(String[] args) throws SQLException {
    Connection connection = null;
    try {
      String url = "jdbc:mysql://localhost:3306/jdbc_course";
      String user = "root";
      String password = "";
      connection = DriverManager.getConnection(url, user, password);
      connection.setAutoCommit(false);
      Statement statement = connection.createStatement();

      String queryInstruction_1 = "DELETE FROM products_table WHERE home_country = 'ESPANA'";
      String queryInstruction_2 = "DELETE FROM products_table WHERE price > 300";
      String queryInstruction_3 = "UPDATE products_table SET price = price * 1.15";

      boolean run = run_Transaction();

      if(run) {
        statement.executeUpdate(queryInstruction_1);
        statement.executeUpdate(queryInstruction_2);
        statement.executeUpdate(queryInstruction_3);

        connection.commit();
        System.out.println("Inserted successfully.");
      } else {
        System.out.println("Insertion failed. No Data Base changes made.");
      }


      connection.close();
    } catch(SQLException e) {
      System.out.println("Wrong insertion: ");
      e.printStackTrace();
      assert connection != null : "Connection is null";
      connection.rollback();
      System.out.println("No changes made.");
    }
  }
   public static boolean run_Transaction() {
     String run = JOptionPane.showInputDialog("Do you want to run the transaction? (Y/N)");

     return run.equals("Y");
   }

}

package Db_StoragedProcedures;

import javax.swing.*;
import javax.swing.JOptionPane;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Upadate_Products {
  public static void main(String[] args) {
    Double nPrice = Double.parseDouble(JOptionPane.showInputDialog("Enter the new price: "));
    String nName = JOptionPane.showInputDialog("Enter the new name: ");
    try {
      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_course", "root", "");
      CallableStatement statement = connection.prepareCall("{call update_Products_Price(?, ?)}");
      statement.setDouble(1, nPrice);
      statement.setString(2, nName);
      statement.execute();

      JOptionPane.showMessageDialog(null, "Product updated!");

      connection.close();
      statement.close();
    } catch(SQLException e) {
      throw new RuntimeException(e);
    }
  }


}

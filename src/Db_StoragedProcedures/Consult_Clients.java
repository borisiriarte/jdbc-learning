package Db_StoragedProcedures;

import java.sql.*;

public class Consult_Clients {
  public static void main(String[] args) {
    try {
      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/storaged_procedures", "root", "");
      CallableStatement statement = connection.prepareCall("{call show_clients}");
      ResultSet rs = statement.executeQuery();
      
      while(rs.next()) {
        System.out.println(rs.getString(1) + " - " + rs.getString(2) + " - " + rs.getString(3) + " - " + rs.getString(4) + " - " + rs.getString(5) + " - " + rs.getString(6));
      }

    } catch(SQLException e) {
      throw new RuntimeException(e);
    }
  }
}

package Db_Transactions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert_Clients_Orders {
  public static void main(String[] args) {
    Connection connection = null;
    try {
      String url = "jdbc:mysql://localhost:3306/storaged_procedures";
      String user = "root";
      String password = "";
      connection = DriverManager.getConnection(url, user, password);
      // --------
      connection.setAutoCommit(false);
      Statement statement = connection.createStatement();
      String queryInstruction_1 = "INSERT INTO clients ( company, address, town, phone, manager) VALUES" +
          " ('Toyota', 'calle 22', 'Cali', '095-123-45-67', 'Boris')";
      statement.executeUpdate(queryInstruction_1);
      String queryInstruction_2 = "INSERT INTO orders (order_id, client_id, order_date) VALUES" +
          " (4, 6, '2022-01-01')";
      statement.executeUpdate(queryInstruction_2);

      // --------
      connection.commit();
      System.out.println("Inserted successfully");
      connection.close();
    } catch(SQLException e) {
      System.out.println("Wrond insertion: ");
      try {
        assert connection != null;
        connection.rollback();
      } catch(SQLException ex) {
        throw new RuntimeException(ex);
      }
      e.printStackTrace();

    }
  }
}

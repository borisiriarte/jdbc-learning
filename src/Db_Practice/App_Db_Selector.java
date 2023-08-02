package Db_Practice;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.JOptionPane;

public class App_Db_Selector {
  public static void main(String[] args) {
    Layout layoutApp = new Layout();
    layoutApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    layoutApp.setVisible(true);
  }
}

class Layout extends JFrame {
  public Layout() {
    setBounds(300, 300, 700, 700);
    sheet sheet = new sheet();
    add(sheet);
  }
}

class sheet extends JPanel {
  private JComboBox<String> tables;
  private JTextArea areaInfo;
  private Connection connection;
  private FileReader input;
  private String db;
  public sheet() {
    setLayout(new BorderLayout());
    tables = new JComboBox<>();
    areaInfo = new JTextArea();
    add(areaInfo, BorderLayout.CENTER);

    Db_Connection();
    getTables();

    tables.addActionListener(e -> {
      String tableName = (String) tables.getSelectedItem();
      areaInfo.setText("");
      showInfoTable(tableName);
    });
    add(tables, BorderLayout.NORTH);

  }

  public void Db_Connection() {
    connection = null;
    String[] data = new String[3];

    try {
      input = new FileReader("src/Db_Practice/db_credentialss.txt");
      BufferedReader reader = new BufferedReader(input);

      for(int i = 0; i < 3; i++) {
        data[i] = reader.readLine();
      }

      db = data[0];
      String url = "jdbc:mysql://localhost:3306/" + db;
      String user = data[1];
      String password = data[2];

      connection = DriverManager.getConnection(url, user, password);

      input.close();
    } catch(SQLException e) {
      e.printStackTrace();
    } catch(IOException e) {
      JFileChooser fileChooser = new JFileChooser();
      int result = fileChooser.showOpenDialog(this);
      if(result == JFileChooser.APPROVE_OPTION) {
        try {
          input = new FileReader(fileChooser.getSelectedFile());
          BufferedReader reader = new BufferedReader(input);

          for(int i = 0; i < 3; i++) {
            data[i] = reader.readLine();
          }

          db = data[0];
          String url = "jdbc:mysql://localhost:3306/" + db;
          String user = data[1];
          String password = data[2];

          connection = DriverManager.getConnection(url, user, password);

          input.close();
        } catch(SQLException | IOException ex) {
          ex.printStackTrace();
        }
      }
    }
  }

  public void getTables() {
    ResultSet rs = null;
    DatabaseMetaData metaData = null;

    try {
      metaData = connection.getMetaData();
      String[] types = {"TABLE"};
      rs = metaData.getTables( db, null, null, types);
      while(rs.next()) {
        String tableName = rs.getString("TABLE_NAME");
        tables.addItem(tableName);
      }
    } catch(SQLException e) {
      e.printStackTrace();
    }
  }

  public void showInfoTable(String tableName) {
    ArrayList< String > columnNames = new ArrayList<>();
    String query = "SELECT * FROM " + tableName;

    try {
      Statement  statement = connection.createStatement();
      ResultSet rs = statement.executeQuery(query);
      ResultSetMetaData rsMetaData = rs.getMetaData();

      for(int i = 1; i <= rsMetaData.getColumnCount(); i++) {
        columnNames.add(rsMetaData.getColumnLabel(i));
      }

      while(rs.next()) {
        for(String columnName: columnNames) {
          areaInfo.append(rs.getString(columnName) + " ");
        }
        areaInfo.append("\n");
      }
    } catch(SQLException e) {
      e.printStackTrace();
    }
  }
}

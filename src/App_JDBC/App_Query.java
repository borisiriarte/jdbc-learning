package App_JDBC;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Objects;

public class App_Query {
  public static void main(String[] args) {
    App_Layout appLayout = new App_Layout();
    appLayout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    appLayout.setVisible(true);
  }
}

class App_Layout extends JFrame {
  private JComboBox<String> secciones;
  private JComboBox<String> paises;
  private JTextArea resultado;
  private final Connection connection;
  private PreparedStatement querySections;
  private final String queryPreparedStatementS = "SELECT * FROM products_table WHERE section_art=?";
  private final String queryPreparedStatementC = "SELECT * FROM products_table WHERE home_country=?";
  private final String queryPreparedStatementSC = "SELECT * FROM products_table WHERE section_art=? AND home_country=?";

  public App_Layout(){

    setTitle ("Data Bases Query");
    setBounds(500,300,400,400);
    setLayout(new BorderLayout());

    JPanel menus=new JPanel();
    menus.setLayout(new FlowLayout());

    secciones=new JComboBox<>();
    secciones.setEditable(false);
    secciones.addItem("Todos");

    paises=new JComboBox<>();
    paises.setEditable(false);
    paises.addItem("Todos");

    resultado= new JTextArea(4,50);
    resultado.setEditable(false);

    add(resultado);

    menus.add(secciones);
    menus.add(paises);

    add(menus, BorderLayout.NORTH);
    add(resultado, BorderLayout.CENTER);

    JButton botonConsulta=new JButton("Consulta");
    botonConsulta.addActionListener(e -> {
      resultado.setText("");
      runQuery();
    });
    add(botonConsulta, BorderLayout.SOUTH);

    //  ------------------ Data Base Connection ------------------
    try {
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_course", "root", "");
      Statement query = connection.createStatement();

      String pQuery = "SELECT DISTINCTROW section_art FROM products_table";
      ResultSet result = query.executeQuery(pQuery);

      while (result.next()) {
        secciones.addItem(result.getString("section_art"));
      }

      pQuery = "SELECT DISTINCTROW home_country FROM products_table";
      result = query.executeQuery(pQuery);

      while (result.next()) {
        paises.addItem(result.getString("home_country"));
      }

      /*connection.close();
      query.close();
      result.close();*/
    } catch(SQLException e) {
      throw new RuntimeException(e);
    }
  }

  private void runQuery() {
      ResultSet rs = null;
    try {
      String section = (String) secciones.getSelectedItem();
      String country = (String) paises.getSelectedItem();
      
      if(!Objects.equals(section, "Todos") && !Objects.equals(country, "Todos")) {
        querySections = connection.prepareStatement(queryPreparedStatementSC);
        querySections.setString(1, section);
        querySections.setString(2, country);
        rs = querySections.executeQuery();
      } else {
        querySections = connection.prepareStatement("SELECT * FROM products_table");
        rs = querySections.executeQuery();
      }
      
      if( Objects.equals(section, "Todos") && !Objects.equals(country, "Todos")) {
        querySections = connection.prepareStatement(queryPreparedStatementC);
        querySections.setString(1, country);
        rs = querySections.executeQuery();
      }
      
      if(!Objects.equals(section, "Todos") && Objects.equals(country, "Todos")) {
        querySections = connection.prepareStatement(queryPreparedStatementS);
        querySections.setString(1, section);
        rs = querySections.executeQuery();
      }

      while (rs.next()) {
        resultado.append( rs.getInt(1) + " - " + rs.getString(2) + " - " + rs.getString(3) + " - " + rs.getString(
            "home_country") + "\n");
      }

      rs.close();
    } catch(SQLException e) {
      throw new RuntimeException(e);
    }
  }
}

package App_JDBC;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

  public App_Layout(){

    setTitle ("Data Bases Query");
    setBounds(500,300,400,400);
    setLayout(new BorderLayout());

    JPanel menus=new JPanel();
    menus.setLayout(new FlowLayout());

    secciones=new JComboBox();
    secciones.setEditable(false);
    secciones.addItem("Todos");

    paises=new JComboBox();
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
    add(botonConsulta, BorderLayout.SOUTH);

    //  ------------------ Data Base Connection ------------------
    try {
      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_course", "root", "");
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

      connection.close();
      query.close();
      result.close();
    } catch(SQLException e) {
      throw new RuntimeException(e);
    }
  }
}

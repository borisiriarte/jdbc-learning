package App_MVC.Vista;

import App_MVC.Controlador.Load_Menus_Controller;
import App_MVC.Controlador.Run_Btn_Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class App_Layout extends JFrame{
  private JComboBox<String> secciones;
  private JComboBox<String> paises;
  private JTextArea resultado;
  public App_Layout() {

    setTitle("Data Bases Query");
    setBounds(500, 300, 400, 400);
    setLayout(new BorderLayout());

    JPanel menus = new JPanel();
    menus.setLayout(new FlowLayout());

    secciones = new JComboBox<>();
    secciones.setEditable(false);
    secciones.addItem("Todos");

    paises = new JComboBox<>();
    paises.setEditable(false);
    paises.addItem("Todos");

    resultado = new JTextArea(4, 50);
    resultado.setEditable(false);

    add(resultado);

    menus.add(secciones);
    menus.add(paises);

    add(menus, BorderLayout.NORTH);
    add(resultado, BorderLayout.CENTER);

    addWindowListener(new Load_Menus_Controller(this));

    JButton botonConsulta = new JButton("Consulta");
    add(botonConsulta, BorderLayout.SOUTH);
    botonConsulta.addActionListener(new Run_Btn_Controller(this));
  }

  public JComboBox< String > getSecciones() {
    return secciones;
  }
  public JComboBox< String > getPaises() {
    return paises;
  }
    public JTextArea getResultado() {
        return resultado;
    }
}

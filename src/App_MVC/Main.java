package App_MVC;

import App_MVC.Vista.App_Layout;
import javax.swing.*;

public class Main {
  public static void main(String[] args) {
    App_Layout appLayout = new App_Layout();
    appLayout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    appLayout.setVisible(true);
  }
}

package App_MVC.Controlador;

import App_MVC.Modelo.Load_Sections;
import App_MVC.Vista.App_Layout;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Load_Sections_Controller extends WindowAdapter {
  Load_Sections obj = new Load_Sections();
  private App_Layout app_layout;

  public Load_Sections_Controller(App_Layout app_layout) {
    this.app_layout = app_layout;
  }
  @Override
  public void windowOpened(WindowEvent e) {
    obj.runQueries();

    try{
     while(obj.getRs().next()) {
       app_layout.getSecciones().addItem(obj.getRs().getString("section_art"));
     }
    } catch(Exception error){
      error.printStackTrace();
    }
  }
}

package App_MVC.Controlador;

import App_MVC.Modelo.Load_Menus;
import App_MVC.Vista.App_Layout;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Load_Menus_Controller extends WindowAdapter {
  Load_Menus obj = new Load_Menus();
  private App_Layout app_layout;

  public Load_Menus_Controller(App_Layout app_layout) {
    this.app_layout = app_layout;
  }
  @Override
  public void windowOpened(WindowEvent e) {
    obj.run_Queries();

    try{
     while(obj.getRsSection().next()) {
       app_layout.getSecciones().addItem(obj.getRsSection().getString("section_art"));
     }

     while(obj.getRsCountry().next()) {
       app_layout.getPaises().addItem(obj.getRsCountry().getString("home_country"));
     }
    } catch(Exception error){
      error.printStackTrace();
    }
  }
}

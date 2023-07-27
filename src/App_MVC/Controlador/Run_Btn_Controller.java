package App_MVC.Controlador;

import App_MVC.Modelo.runQueries;
import App_MVC.Vista.App_Layout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Run_Btn_Controller implements ActionListener {
    private App_Layout app_layout;
    private runQueries obj = new runQueries();
    private ResultSet rs;
    public Run_Btn_Controller(App_Layout app_layout) {
        this.app_layout = app_layout;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedSection = (String) app_layout.getSecciones().getSelectedItem();
        String selectedCountry = (String) app_layout.getPaises().getSelectedItem();

        try {
            rs = obj.filterDB(selectedSection, selectedCountry);
            while(rs.next()) {
                app_layout.getResultado().append(rs.getString(1) + " - " + rs.getString(2) + " - " +  rs.getString(3) + " - " + rs.getString("home_country") + "\n");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}

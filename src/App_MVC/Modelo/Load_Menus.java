package App_MVC.Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Load_Menus {
    private Connection_Db connection;
    private ResultSet rsSection;
    private ResultSet rsCountry;

    public Load_Menus() {
        connection = new Connection_Db();
    }

    public void run_Queries(){
        Db_Products product;
        Connection access_Db = connection.gimmeConnection();

        try {
            Statement sections = access_Db.createStatement();
            Statement countries = access_Db.createStatement();
            rsSection = sections.executeQuery("SELECT DISTINCTROW section_art FROM products_table");
            rsCountry = countries.executeQuery("SELECT DISTINCTROW home_country FROM products_table");

            product = new Db_Products();
            rsCountry.next();
            rsSection.next();
            product.setSection(rsSection.getString("section_art"));
            product.setCountry(rsCountry.getString("home_country"));

            /*rsSection.close();
            rsCountry.close();*/
            /*sections.close();
            countries.close();
            access_Db.close();*/
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ResultSet getRsSection() {
        return rsSection;
    }
    public ResultSet getRsCountry() {
        return rsCountry;
    }

}




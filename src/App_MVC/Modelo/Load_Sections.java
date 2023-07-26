package App_MVC.Modelo;

import App_MVC.Controlador.Connection_Db;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Load_Sections {
    private Connection_Db connection;
    private ResultSet rs;
    public Load_Sections() {
        connection = new Connection_Db();
    }

    public String runQueries(){
        Db_Products product = null;
        Connection access_Db = connection.gimmeConnection();

        try {
            Statement sections = access_Db.createStatement();
            rs = sections.executeQuery("SELECT DISTINCTROW section_art FROM products_table");
            
            while(rs.next()) {
                product = new Db_Products();
                product.setSection(rs.getString("section_art"));
                return product.getSection();
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Something went wrong. Error: " + e.getMessage());
        }
        return product.getSection();
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public ResultSet getRs() {
        return rs;
    }
}

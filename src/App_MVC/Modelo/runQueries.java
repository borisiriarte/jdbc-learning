package App_MVC.Modelo;

import java.sql.*;

public class runQueries {
    private Connection_Db connection;
    private ResultSet rs;
    private PreparedStatement ps;
    String query;

    public runQueries() {
        connection = new Connection_Db();
    }
    public ResultSet filterDB(String section, String country) throws SQLException {
        query = "SELECT * FROM products_table";
        Connection conect = connection.gimmeConnection();
        this.rs = null;
        if(section.equals("Todos") && !country.equals("Todos")) {
            query = "SELECT * FROM products_table WHERE home_country = ?";
            this.ps = conect.prepareStatement(query);
            this.ps.setString(1, country);
            this.rs = this.ps.executeQuery();
        }
        if(!section.equals("Todos") && country.equals("Todos")) {
            query = "SELECT * FROM products_table WHERE section_art = ?";
            this.ps = conect.prepareStatement(query);
            this.ps.setString(1, section);
            this.rs = this.ps.executeQuery();
        }

        if(!section.equals("Todos") && !country.equals("Todos")) {
            query = "SELECT * FROM products_table WHERE section_art = ? AND home_country = ?";
            this.ps = conect.prepareStatement(query);
            this.ps.setString(1, section);
            this.ps.setString(2, country);
            this.rs = this.ps.executeQuery();
        } else {
            this.ps = conect.prepareStatement(query);
            this.rs = this.ps.executeQuery();
        }
        
        return rs;
    }
}

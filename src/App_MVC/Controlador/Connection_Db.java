package App_MVC.Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection_Db {
    Connection connection = null;
    public Connection_Db(){}

    public Connection gimmeConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_course", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}

package Connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    public Connection connection;
    private static DataBase instance;
    private DataBase(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/m_electronic", "root", "");
        } catch (SQLException ex) {
            ex.getStackTrace();
        }
    }
    
    public static DataBase getInstance() throws SQLException{
        if(instance == null || instance.connection.isClosed()){
            instance = new DataBase();
        }
        return instance;
    }
}
